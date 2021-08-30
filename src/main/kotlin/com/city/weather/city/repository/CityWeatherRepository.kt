package com.city.weather.city.repository

import com.city.weather.city.model.City
import com.city.weather.city.model.Weather
import com.city.weather.city.response.CityAvgTempDto
import java.util.*

interface CityWeatherRepository {

    fun findAllWeathersByCityId(cityId: Long?): List<Weather?>?

    fun saveWeathers(weathers: List<Weather>): IntArray

    fun findCitiesAvgTemp(): List<CityAvgTempDto>

    fun findAllCities(): MutableList<City>?

    fun findCityById(id: Long?): Optional<City>

    fun findCityAvgTemp(id: Long?): Optional<CityAvgTempDto>

    fun findAllCitiesIdAndName(): List<City>


}