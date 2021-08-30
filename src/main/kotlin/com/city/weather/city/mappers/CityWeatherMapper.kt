package com.city.weather.city.mappers

import com.city.weather.city.model.City
import com.city.weather.city.model.Weather
import com.city.weather.city.response.CityDto
import com.city.weather.city.response.WeatherDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CityWeatherMapper {

    @Mapping(target = "cityId", source = "id")
    fun toCityDto(model: City): CityDto

    fun toCityDtoList(models: MutableList<City>?): MutableList<CityDto>

    fun toWeatherDto(weather: Weather): WeatherDto

    fun toWeatherDtoList(weathers: List<Weather>): List<WeatherDto>
}
