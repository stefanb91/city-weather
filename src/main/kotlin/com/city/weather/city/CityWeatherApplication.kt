package com.city.weather.city

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CityWeatherApplication

fun main(args: Array<String>) {
    runApplication<CityWeatherApplication>(*args)
}
