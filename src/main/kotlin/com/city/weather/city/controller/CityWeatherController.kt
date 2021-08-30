package com.city.weather.city.controller

import com.city.weather.city.response.CityAvgTempDto
import com.city.weather.city.response.CityDto
import com.city.weather.city.service.CityWeatherService
import com.google.common.base.Preconditions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/weather")
class CityWeatherController(@Autowired val cityWeatherService: CityWeatherService) {

    @GetMapping("/cities")
    fun findAllCities(): ResponseEntity<List<CityDto>> = ResponseEntity<List<CityDto>>(cityWeatherService.findAllCities(), HttpStatus.OK)

    @GetMapping("/cities/average-temperature")
    fun averageTempOfCities(): ResponseEntity<List<CityAvgTempDto>> =
        ResponseEntity(cityWeatherService.findAvgCitiesTemp(), HttpStatus.OK);

    @GetMapping("/city/{id}")
    fun getCityById(@PathVariable id: Long): ResponseEntity<CityDto> {
        Preconditions.checkArgument(id > BigDecimal.ZERO.toLong())
        return ResponseEntity.of(cityWeatherService.getCityById(id))
    }

    @GetMapping("/city/{id}/average-temperature")
    fun getCityAvgTemp(@PathVariable id: Long): ResponseEntity<CityAvgTempDto> {
        Preconditions.checkArgument(id > BigDecimal.ZERO.toLong())
        return ResponseEntity.of(cityWeatherService.getCityAvgTemp(id))
    }
}