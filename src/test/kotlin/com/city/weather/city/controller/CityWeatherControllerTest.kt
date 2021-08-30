package com.city.weather.city.controller

import com.city.weather.city.response.CityAvgTempDto
import com.city.weather.city.response.CityDto
import com.city.weather.city.response.WeatherDto
import com.city.weather.city.service.CityWeatherService
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import java.math.BigDecimal
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class CityWeatherControllerTest {

    @MockBean
    lateinit var cityWeatherService: CityWeatherService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun findAllCities() {
        val dot1 = CityDto(2643743L, "London", listOf<WeatherDto>())
        val dot2 = CityDto(524901L, "Moscow", listOf<WeatherDto>())
        val dot3 = CityDto(2988507L, "Paris", listOf<WeatherDto>())

        val cities: MutableList<CityDto> = ArrayList<CityDto>()
        cities.add(dot1)
        cities.add(dot2)
        cities.add(dot3)

        Mockito.`when`(cityWeatherService.findAllCities()).thenReturn(cities)

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/cities"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize<Any>(3)))
            .andExpect(jsonPath("$[0].cityId", Matchers.`is`(dot1.cityId.toInt())))
            .andExpect(jsonPath("$[0].cityName", Matchers.`is`(dot1.cityName)))
            .andExpect(jsonPath("$[1].cityId", Matchers.`is`(dot2.cityId.toInt())))
            .andExpect(jsonPath("$[1].cityName", Matchers.`is`(dot2.cityName)))
            .andExpect(jsonPath("$[2].cityId", Matchers.`is`(dot3.cityId.toInt())))
            .andExpect(jsonPath("$[2].cityName", Matchers.`is`(dot3.cityName)))
    }

    @Test
    fun citiesAverageTemperatures() {
        val dto1 = CityAvgTempDto("London", BigDecimal.TEN)
        val dto2 = CityAvgTempDto("Moscow", BigDecimal.TEN)
        val dto3 = CityAvgTempDto("Paris", BigDecimal.TEN)

        val citiesAverageTempDto: MutableList<CityAvgTempDto> = java.util.ArrayList<CityAvgTempDto>()
        citiesAverageTempDto.add(dto1)
        citiesAverageTempDto.add(dto2)
        citiesAverageTempDto.add(dto3)

        Mockito.`when`(cityWeatherService.findAvgCitiesTemp()).thenReturn(citiesAverageTempDto)

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/cities/average-temperature"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$", Matchers.hasSize<Any>(3)))
            .andExpect(jsonPath("$[0].cityName", Matchers.`is`(dto1.cityName)))
            .andExpect(jsonPath("$[0].tempAvg", Matchers.`is`(dto1.tempAvg.toInt())))
            .andExpect(jsonPath("$[1].cityName", Matchers.`is`(dto2.cityName)))
            .andExpect(jsonPath("$[1].tempAvg", Matchers.`is`(dto2.tempAvg.toInt())))
            .andExpect(jsonPath("$[2].cityName", Matchers.`is`(dto3.cityName)))
            .andExpect(jsonPath("$[2].tempAvg", Matchers.`is`(dto3.tempAvg.toInt())))
    }

    @Test
    fun getCityById() {

        Mockito.`when`(cityWeatherService.getCityById(524901L)).thenReturn(Optional.of(CityDto(524901L, "Moscow", listOf())))

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/city/524901"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.cityId", Matchers.`is`(524901)))
            .andExpect(jsonPath("$.cityName", Matchers.`is`("Moscow")))
    }

    @Test
    fun getCityAvgTemp() {
        Mockito.`when`(cityWeatherService.getCityAvgTemp(524901L)).thenReturn(Optional.of(CityAvgTempDto("Moscow", BigDecimal.TEN)))

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/city/524901/average-temperature"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.cityName", Matchers.`is`("Moscow")))
            .andExpect(jsonPath("$.tempAvg", Matchers.`is`(BigDecimal.TEN.toInt())))
    }
}