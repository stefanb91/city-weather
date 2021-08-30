package com.city.weather.city.response.weatherapi

data class WeatherMapDto(
    var cod: String,
    var message: String,
    var cnt: Int,
    var list: List<WeatherMapListDto>,
    var city: WeatherMapCityDto
)