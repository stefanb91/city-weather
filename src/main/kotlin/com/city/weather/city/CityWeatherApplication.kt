package com.city.weather.city

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "City weather API",
    version = "1.0", description = "City weathers information"))
class CityWeatherApplication

fun main(args: Array<String>) {
    runApplication<CityWeatherApplication>(*args)
}
