package com.city.weather.city.service

import com.city.weather.city.mappers.CityWeatherMapper
import com.city.weather.city.mappers.OpenWeatherMapper
import com.city.weather.city.model.City
import com.city.weather.city.repository.CityWeatherRepository
import com.city.weather.city.response.CityAvgTempDto
import com.city.weather.city.response.CityDto
import com.city.weather.city.response.weatherapi.WeatherMapDto
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.mapstruct.factory.Mappers
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import java.util.*

@Service
class CityWeatherService(@Autowired val cityWeatherRepository: CityWeatherRepository) : InitializingBean {

    val log: Logger = LoggerFactory.getLogger(CityWeatherService::class.java)

    val mapper = jacksonObjectMapper();

    //    @Value("\${URL_PATH}")
    var URL_PATH: String = "api.openweathermap.org/data/2.5"

    //    @Value("\${API_KEY}")
    var API_KEY: String = "75375a11808dbeac5d70fc3395cf1d67"

    //    @Value("\${URI_PATH}")
    var URI_PATH: String = "/forecast"


    @Throws(JsonProcessingException::class)
    fun performApiByCityName(cityName: String?): WeatherMapDto {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        return mapper.readValue(WebClient.create(URL_PATH)
            .get()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path(URI_PATH)
                    .queryParam("q", cityName)
                    .queryParam("appid", API_KEY)
                    .build()
            }
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(String::class.java)
            .block(), WeatherMapDto::class.java);
    }

    fun fetchAndPersistWeathersByCity(): Unit {
        cityWeatherRepository.findAllCitiesIdAndName().forEach { c ->
            try {
                val mapDto: WeatherMapDto = performApiByCityName(c.cityName)
                val city: City? = Mappers.getMapper(OpenWeatherMapper::class.java).toCity(mapDto)
                val batch: IntArray = cityWeatherRepository.saveWeathers(city?.weathers ?: listOf())
                log.info("Size of batch: " + batch.size)
            } catch (e: JsonProcessingException) {
                log.error("JSON deserialization failed! ", e)
            }
        }
    }

    fun findAvgCitiesTemp(): List<CityAvgTempDto> = cityWeatherRepository.findCitiesAvgTemp()

    fun findAllCities(): MutableList<CityDto> =
        Mappers.getMapper(CityWeatherMapper::class.java).toCityDtoList(cityWeatherRepository.findAllCities());

    fun getCityById(id: Long?): Optional<CityDto> =
        Optional.ofNullable(
            Mappers.getMapper(CityWeatherMapper::class.java).toCityDto(cityWeatherRepository.findCityById(id).get())
        )

    fun getCityAvgTemp(id: Long?) = cityWeatherRepository.findCityAvgTemp(id)

    override fun afterPropertiesSet() {
        fetchAndPersistWeathersByCity()
    }
}