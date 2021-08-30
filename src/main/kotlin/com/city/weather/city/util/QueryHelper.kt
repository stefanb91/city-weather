package com.city.weather.city.util

class QueryHelper {
    companion object {
        const val CITIES_AVG_TEMP: String = "SELECT c.city_name, ROUND (avg(temp_value),2) as avg_temp " +
                "FROM city c LEFT JOIN weather w ON c.id = w.city_id " +
                "GROUP BY city_name " +
                "ORDER BY avg_temp DESC"

        const val FIND_CITY_AVG_TEMP: String = "SELECT c.city_name, ROUND (avg(temp_value),2) as avg_temp " +
                "FROM city c LEFT JOIN weather w ON c.id = w.city_id " +
                "WHERE c.id = %d " +
                "GROUP BY city_name " +
                "ORDER BY avg_temp DESC"

        const val FIND_ALL_CITIES: String = "SELECT c.id as id, c.city_name, c.country, c.timezone," +
                "    w.ind as weathers_ind, w.id as weathers_id , w.city_id as weathers_cityId, w.temp_value as weathers_tempValue , w.main as weathers_main, w.dt as weathers_dt" +
                " FROM city c" +
                "    left join weather w on w.city_id = c.id" +
                " ORDER BY c.id, w.ind"

        const val FIND_CITY_BY_ID: String = "SELECT c.id as id, c.city_name, c.country, c.timezone," +
                "    w.ind as weathers_ind, w.id as weathers_id , w.city_id as weathers_cityId, w.temp_value as weathers_tempValue , w.main as weathers_main, w.dt as weathers_dt" +
                " FROM city c" +
                "    left join weather w on w.city_id = c.id" +
                " WHERE c.id = %d" +
                " ORDER BY c.id, w.ind"
    }
}