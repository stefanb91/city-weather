package com.city.weather.city.dao

import com.city.weather.city.mappers.OpenWeatherMapper
import com.city.weather.city.model.City
import com.city.weather.city.model.Weather
import com.city.weather.city.repository.CityWeatherRepository
import com.city.weather.city.response.CityAvgTempDto
import com.city.weather.city.response.weatherapi.WeatherMapDto
import com.city.weather.city.utils.CityWeatherMySqlContainer
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.io.File
import java.io.IOException
import java.math.BigDecimal
import java.util.*
import java.util.function.Consumer

@SpringBootTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class CityWeatherDaoTest {

    @Container
    val mySqlContainer = CityWeatherMySqlContainer(image = "mysql:8.0")
        .withDatabaseName("city_weather_test_container")
        .withUsername("testuser")
        .withPassword("pass");

    @Autowired
    lateinit var repository: CityWeatherRepository

    var mapper = ObjectMapper().registerModule(KotlinModule())

    companion object {
        val RESOURCE_PATH: String = "src/test/resources/test-file/open_weather_api_response.json"
    }

    // TODO: use test containers
    @Test
    @Sql(scripts = ["classpath:schema.sql", "classpath:data.sql"])
    @Throws(IOException::class)
    fun saveWeathersAndFindAllByCityId() {
        mapper.configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false
        )
        val jsonFile: File = File(RESOURCE_PATH)
        if (jsonFile.exists()) {
            val responseDto: WeatherMapDto =
                mapper.readValue(
                    jsonFile,
                    WeatherMapDto::class.java
                )
            val city: City = Mappers.getMapper(OpenWeatherMapper::class.java).toCity(responseDto)

            // batch insert
            for (r in repository.saveWeathers(city.weathers)) Assertions.assertTrue(r == BigDecimal.ONE.toInt())
            val weathers: List<Weather?>? = repository.findAllWeathersByCityId(city.id)
            Assertions.assertFalse(weathers!!.isEmpty())
            Assertions.assertTrue(weathers!!.size >= city.weathers.size)
        } else Assertions.fail<Any>()
    }

    @Test
    fun findAllWeathersByCityId() {
    }

    @Test
    @Sql(scripts = ["classpath:schema.sql", "classpath:data_all.sql"])
    fun findCitiesAvgTemp() {
        val cities: MutableList<Long> = ArrayList()
        cities.add(2643743L)
        cities.add(524901L)
        cities.add(2988507L)

        val avgTemps: List<CityAvgTempDto> = repository.findCitiesAvgTemp()
        Assertions.assertFalse(avgTemps.isEmpty())
        Assertions.assertTrue(avgTemps.size == 3)

        // comparing average temperature with zero, because weather data are changed
        avgTemps.forEach(Consumer<CityAvgTempDto> { avt: CityAvgTempDto ->
            Assertions.assertTrue(
                avt.tempAvg.compareTo(BigDecimal.ZERO) === BigDecimal.ONE.toInt()
            )
        })
    }

    @Test
    @Sql(scripts = ["classpath:schema.sql", "classpath:data_all.sql"])
    fun findAllCities() {
        val cities = repository.findAllCities()
        Assertions.assertFalse(cities!!.isEmpty())
        Assertions.assertTrue(cities.size == 3)
        Assertions.assertTrue(cities.get(BigDecimal.ZERO.toInt()).weathers.size > BigDecimal.ZERO.toInt())
    }

    @Test
    @Sql(scripts = ["classpath:schema.sql", "classpath:data_all.sql"])
    fun findCityById() {
        val cityOpt: Optional<City> = repository.findCityById(524901L)
        Assertions.assertTrue(cityOpt.isPresent)
        Assertions.assertTrue(cityOpt.get().cityName.equals("Moscow"))
        Assertions.assertTrue(cityOpt.get().weathers.size > BigDecimal.ZERO.toInt())
    }

    @Test
    @Sql(scripts = ["classpath:schema.sql", "classpath:data_all.sql"])
    fun findCityAvgTemp() {
        val cityAvgTempOpt: Optional<CityAvgTempDto> = repository.findCityAvgTemp(524901L)
        Assertions.assertTrue(cityAvgTempOpt.isPresent)
        Assertions.assertTrue(cityAvgTempOpt.get().cityName == "Moscow")
        Assertions.assertTrue(cityAvgTempOpt.get().tempAvg.compareTo(BigDecimal.ZERO) > BigDecimal.ZERO.toInt())
    }

    @Test
    fun findAllCitiesIdAndName() {
    }
}