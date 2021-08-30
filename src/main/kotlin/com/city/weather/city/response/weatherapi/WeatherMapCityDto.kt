package com.city.weather.city.response.weatherapi

data class WeatherMapCityDto(
    var id: Long,
    var name: String,
    var country: String,
    var timezone: Long
)