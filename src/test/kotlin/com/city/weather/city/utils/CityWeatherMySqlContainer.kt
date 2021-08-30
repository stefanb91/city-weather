package com.city.weather.city.utils

import org.testcontainers.containers.MySQLContainer

internal class CityWeatherMySqlContainer(val image: String) : MySQLContainer<CityWeatherMySqlContainer>(image) {
}