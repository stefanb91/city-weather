package com.city.weather.city.model

import java.math.BigDecimal

data class Weather(
    val ind: Long,
    val id: Long,
    var cityId: Long,
    val tempValue: BigDecimal,
    val main: String,
    val dt: String
)