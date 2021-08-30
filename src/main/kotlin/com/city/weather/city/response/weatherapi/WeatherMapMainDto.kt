package com.city.weather.city.response.weatherapi

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class WeatherMapMainDto(
    var temp: BigDecimal,
    @JsonProperty("temp_min")
    var tempMin: BigDecimal,
    @JsonProperty("temp_max")
    var tempMax: BigDecimal
)