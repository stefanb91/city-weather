package com.city.weather.city.response.weatherapi

import com.fasterxml.jackson.annotation.JsonProperty

data class WeatherMapListDto(
    var main: WeatherMapMainDto,
    var weather: List<WeatherMapWeatherDto>,
    @JsonProperty("dt_txt")
    var dtTxt: String
)