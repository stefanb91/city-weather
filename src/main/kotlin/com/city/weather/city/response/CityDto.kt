package com.city.weather.city.response

class CityDto(
    val cityId: Long,
    val cityName: String,
    val weathers: List<WeatherDto>
)