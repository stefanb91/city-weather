package com.city.weather.city.model

import com.city.weather.city.service.KotlinBuilder

@KotlinBuilder
data class City(
    var id: Long,
    var cityName: String,
    var country: String,
    var timezone: Int,
    var weathers: List<Weather>
)
//{
//    constructor(id: Long, cityName: String) : this(id, cityName, String(), 0, listOf())
//}