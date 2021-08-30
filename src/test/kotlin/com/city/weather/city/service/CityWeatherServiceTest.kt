package com.city.weather.city.service

import com.city.weather.city.model.City
import com.city.weather.city.repository.CityWeatherRepository
import com.city.weather.city.response.CityAvgTempDto
import com.city.weather.city.response.CityDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
internal class CityWeatherServiceTest {

    @Autowired
    lateinit var cityWeatherService: CityWeatherService

    @MockBean
    lateinit var repository: CityWeatherRepository

//    @Test
//    fun performApiByCityName() {
//    }
//
//    @Test
//    fun fetchAndPersistWeathersByCity() {
//    }

    @Test
    fun findAvgCitiesTemp() {
        val cities: List<CityAvgTempDto> = ArrayList<CityAvgTempDto>()
        Mockito.`when`(repository.findCitiesAvgTemp()).thenReturn(cities)

        val avgCities: List<CityAvgTempDto> = cityWeatherService.findAvgCitiesTemp()

        assertTrue(avgCities.isEmpty())
        assertFalse(!avgCities.isEmpty())
    }

    @Test
    fun findAllCities() {
        val cities: MutableList<City> = java.util.ArrayList<City>()
        val city1 = City(2643743L, "London", "", 0, listOf())
        val city2 = City(524901L, "Moscow", "", 0, listOf())
        val city3 = City(2988507L, "Paris", "", 0, listOf())

        cities.add(city1)
        cities.add(city2)
        cities.add(city3)

        Mockito.`when`(repository.findAllCities()).thenReturn(cities)

        val listDto: List<CityDto> = cityWeatherService.findAllCities()
        assertFalse(listDto.isEmpty())
        assertTrue(listDto.size == 3)

        for (i in 0..2) {
            assertTrue(cities[i].cityName.equals(listDto[i].cityName))
            assertTrue(cities[i].id.equals(listDto[i].cityId))
        }
    }

//    @Test
//    fun getCityById() {
//    }
//
//    @Test
//    fun getCityAvgTemp() {
//    }
}