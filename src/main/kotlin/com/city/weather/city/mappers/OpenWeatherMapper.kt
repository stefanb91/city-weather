package com.city.weather.city.mappers

import com.city.weather.city.model.City
import com.city.weather.city.model.Weather
import com.city.weather.city.response.weatherapi.WeatherMapDto
import com.city.weather.city.response.weatherapi.WeatherMapListDto
import org.mapstruct.*

@Mapper(componentModel = "spring")
interface OpenWeatherMapper {

    @AfterMapping
    @JvmDefault
    fun fillUp(source: WeatherMapDto, @MappingTarget city: City) {
        city.weathers?.forEach { weather -> weather.cityId = city.id }
    }

    @Mappings(
        Mapping(target = "id", source = "city.id"),
        Mapping(target = "cityName", source = "city.name"),
        Mapping(target = "country", source = "city.country"),
        Mapping(target = "timezone", source = "city.timezone"),
        Mapping(target = "weathers", source = "list")
    )
    fun toCity(dto: WeatherMapDto): City


    @Mappings(
        Mapping(target = "tempValue", source = "main.temp"),
        Mapping(target = "dt", source = "dtTxt"),
        Mapping(expression = "java(dto.getWeather().get(0).getMain())", target = "main"),
        Mapping(expression = "java(dto.getWeather().get(0).getId())", target = "id"),
        Mapping(target = "cityId", ignore = true)
    )
    fun toWeather(dto: WeatherMapListDto): Weather

}