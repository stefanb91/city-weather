package com.city.weather.city.dao

import com.city.weather.city.model.City
import com.city.weather.city.model.Weather
import com.city.weather.city.repository.CityWeatherRepository
import com.city.weather.city.response.CityAvgTempDto
import com.city.weather.city.util.QueryHelper
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*

@Component
class CityWeatherDao(@Autowired val jdbcTemplate: JdbcTemplate) : CityWeatherRepository {

    @Transactional
    override fun saveWeathers(weathers: List<Weather>): IntArray = jdbcTemplate.batchUpdate(
        "INSERT into WEATHER (id, city_id, temp_value, main, dt, created_at) VALUES "
                + "(?,?,?,?,?,?)", object : BatchPreparedStatementSetter {
            @Throws(SQLException::class)
            override fun setValues(ps: PreparedStatement, i: Int) {
                ps.setInt(1, weathers[i].id?.toInt() ?: 0)
                ps.setInt(2, weathers[i].cityId?.toInt() ?: 0)
                ps.setBigDecimal(3, weathers[i].tempValue ?: null)
                ps.setString(4, weathers[i].main)
                ps.setString(5, weathers[i].dt)
                ps.setDate(6, Date(System.currentTimeMillis()))
            }

            override fun getBatchSize(): Int {
                return weathers?.size
            }
        })

    override fun findAllWeathersByCityId(cityId: Long?): List<Weather> = jdbcTemplate.query(
        "SELECT ind, id, city_id, temp_value, main, dt " +
                "FROM Weather WHERE city_id = ?",
        { rs: ResultSet, _: Int ->
            Weather(
                rs.getLong("ind"),
                rs.getLong("id"),
                rs.getLong("city_id"),
                rs.getBigDecimal("temp_value"),
                rs.getString("main"),
                rs.getString("dt")
            )
        }, cityId
    )

    override fun findCitiesAvgTemp(): List<CityAvgTempDto> = jdbcTemplate.query(
        QueryHelper.CITIES_AVG_TEMP
    ) { rs, _ ->
        CityAvgTempDto(
            rs.getString("city_name"),
            rs.getBigDecimal("avg_temp")
        )
    }

    override fun findAllCities(): MutableList<City>? = jdbcTemplate.query(
        QueryHelper.FIND_ALL_CITIES,
        JdbcTemplateMapperFactory
            .newInstance()
            .addKeys("id", "weathers_ind") // the  id column for City
            .newResultSetExtractor(City::class.java)
    )

    override fun findCityById(id: Long?): Optional<City> {
        val cities: MutableList<City>? = jdbcTemplate.query(
            String.format(QueryHelper.FIND_CITY_BY_ID, id),
            JdbcTemplateMapperFactory
                .newInstance()
                .addKeys("id", "weathers_ind") // the  id column for City
                .newResultSetExtractor(City::class.java)
        )

        // TODO: discuss about this part of code
        if (cities?.size === BigDecimal.ONE.toInt())
            return Optional.ofNullable(cities[BigDecimal.ZERO.toInt()])
        else
            return Optional.empty()
    }

    override fun findCityAvgTemp(id: Long?): Optional<CityAvgTempDto> = Optional.ofNullable(jdbcTemplate.queryForObject(
        String.format(QueryHelper.FIND_CITY_AVG_TEMP, id)
    ) { rs, _ ->
        CityAvgTempDto(
            rs.getString("city_name"),
            rs.getBigDecimal("avg_temp")
        )
    })

    override fun findAllCitiesIdAndName(): List<City> = jdbcTemplate.query<City>("SELECT id, city_name " +
            "FROM city",
        RowMapper { rs: ResultSet, _: Int ->
            City(
                rs.getLong("id"),
                rs.getString("city_name"),
                "",
                0,
                listOf()
            )
        })
}