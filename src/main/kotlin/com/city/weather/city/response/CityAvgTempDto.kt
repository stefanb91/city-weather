package com.city.weather.city.response

import java.math.BigDecimal

data class CityAvgTempDto(
    val cityName: String,
    val tempAvg: BigDecimal
)