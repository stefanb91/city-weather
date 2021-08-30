SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE city;
TRUNCATE weather;
SET FOREIGN_KEY_CHECKS = 1;

insert into city (id, city_name, country, timezone, created_at) values (2643743, "London", "GB", 3600, NOW());
insert into city (id, city_name, country, timezone, created_at) values (524901, "Moscow", "RU", 10800, NOW());
insert into city (id, city_name, country, timezone, created_at) values (2988507, "Paris", "FR", 7200, NOW());


insert into weather (id, city_id, temp_value, main, dt, created_at) values
(804,524901,291.58,"Clouds","2021-08-27 18:00:00","2021-08-27 00:00:00"),
(804,524901,291.17,"Clouds","2021-08-27 21:00:00","2021-08-27 00:00:00"),
(804,524901,290.47,"Clouds","2021-08-28 00:00:00","2021-08-27 00:00:00"),
(804,524901,288.71,"Clouds","2021-08-28 03:00:00","2021-08-27 00:00:00"),
(804,524901,290.93,"Clouds","2021-08-28 06:00:00","2021-08-27 00:00:00"),
(803,524901,294.9,"Clouds","2021-08-28 09:00:00","2021-08-27 00:00:00"),
(802,524901,296.17,"Clouds","2021-08-28 12:00:00","2021-08-27 00:00:00"),
(802,524901,295.05,"Clouds","2021-08-28 15:00:00","2021-08-27 00:00:00"),
(802,524901,291.43,"Clouds","2021-08-28 18:00:00","2021-08-27 00:00:00"),
(804,524901,290.68,"Clouds","2021-08-28 21:00:00","2021-08-27 00:00:00"),
(804,524901,289.01,"Clouds","2021-08-29 00:00:00","2021-08-27 00:00:00"),
(804,524901,288.91,"Clouds","2021-08-29 03:00:00","2021-08-27 00:00:00"),
(804,524901,290.46,"Clouds","2021-08-29 06:00:00","2021-08-27 00:00:00"),
(804,524901,295.68,"Clouds","2021-08-29 09:00:00","2021-08-27 00:00:00"),
(804,524901,298.37,"Clouds","2021-08-29 12:00:00","2021-08-27 00:00:00"),
(803,524901,297.89,"Clouds","2021-08-29 15:00:00","2021-08-27 00:00:00"),
(804,524901,293.47,"Clouds","2021-08-29 18:00:00","2021-08-27 00:00:00"),
(803,524901,291.22,"Clouds","2021-08-29 21:00:00","2021-08-27 00:00:00"),
(803,524901,289.68,"Clouds","2021-08-30 00:00:00","2021-08-27 00:00:00"),
(500,524901,288.84,"Rain","2021-08-30 03:00:00","2021-08-27 00:00:00"),
(500,524901,292.27,"Rain","2021-08-30 06:00:00","2021-08-27 00:00:00"),
(500,524901,297.04,"Rain","2021-08-30 09:00:00","2021-08-27 00:00:00"),
(500,524901,298.48,"Rain","2021-08-30 12:00:00","2021-08-27 00:00:00"),
(500,524901,294.23,"Rain","2021-08-30 15:00:00","2021-08-27 00:00:00"),
(500,524901,289.84,"Rain","2021-08-30 18:00:00","2021-08-27 00:00:00"),
(500,524901,288.14,"Rain","2021-08-30 21:00:00","2021-08-27 00:00:00"),
(500,524901,287.32,"Rain","2021-08-31 00:00:00","2021-08-27 00:00:00"),
(804,524901,286.54,"Clouds","2021-08-31 03:00:00","2021-08-27 00:00:00"),
(804,524901,289.12,"Clouds","2021-08-31 06:00:00","2021-08-27 00:00:00"),
(803,524901,294.33,"Clouds","2021-08-31 09:00:00","2021-08-27 00:00:00"),
(803,524901,298.08,"Clouds","2021-08-31 12:00:00","2021-08-27 00:00:00"),
(803,524901,297.67,"Clouds","2021-08-31 15:00:00","2021-08-27 00:00:00"),
(803,524901,293.77,"Clouds","2021-08-31 18:00:00","2021-08-27 00:00:00"),
(804,524901,292.6,"Clouds","2021-08-31 21:00:00","2021-08-27 00:00:00"),
(804,524901,291.21,"Clouds","2021-09-01 00:00:00","2021-08-27 00:00:00"),
(804,524901,291.21,"Clouds","2021-09-01 03:00:00","2021-08-27 00:00:00"),
(804,524901,293.16,"Clouds","2021-09-01 06:00:00","2021-08-27 00:00:00"),
(804,524901,294.4,"Clouds","2021-09-01 09:00:00","2021-08-27 00:00:00"),
(804,524901,295.46,"Clouds","2021-09-01 12:00:00","2021-08-27 00:00:00"),
(500,524901,293.54,"Rain","2021-09-01 15:00:00","2021-08-27 00:00:00"),
(804,2643743,291.85,"Clouds","2021-08-27 18:00:00","2021-08-27 00:00:00"),
(803,2643743,290.59,"Clouds","2021-08-27 21:00:00","2021-08-27 00:00:00"),
(802,2643743,288.23,"Clouds","2021-08-28 00:00:00","2021-08-27 00:00:00"),
(800,2643743,285.69,"Clear","2021-08-28 03:00:00","2021-08-27 00:00:00"),
(800,2643743,285.52,"Clear","2021-08-28 06:00:00","2021-08-27 00:00:00"),
(802,2643743,289.73,"Clouds","2021-08-28 09:00:00","2021-08-27 00:00:00"),
(803,2643743,292.45,"Clouds","2021-08-28 12:00:00","2021-08-27 00:00:00"),
(804,2643743,293.6,"Clouds","2021-08-28 15:00:00","2021-08-27 00:00:00"),
(803,2643743,292.2,"Clouds","2021-08-28 18:00:00","2021-08-27 00:00:00"),
(800,2643743,288.76,"Clear","2021-08-28 21:00:00","2021-08-27 00:00:00"),
(800,2643743,287.13,"Clear","2021-08-29 00:00:00","2021-08-27 00:00:00"),
(800,2643743,286.05,"Clear","2021-08-29 03:00:00","2021-08-27 00:00:00"),
(800,2643743,285.49,"Clear","2021-08-29 06:00:00","2021-08-27 00:00:00"),
(800,2643743,289.18,"Clear","2021-08-29 09:00:00","2021-08-27 00:00:00"),
(800,2643743,293.15,"Clear","2021-08-29 12:00:00","2021-08-27 00:00:00"),
(800,2643743,294.62,"Clear","2021-08-29 15:00:00","2021-08-27 00:00:00"),
(800,2643743,292.25,"Clear","2021-08-29 18:00:00","2021-08-27 00:00:00"),
(800,2643743,288.3,"Clear","2021-08-29 21:00:00","2021-08-27 00:00:00"),
(801,2643743,286.91,"Clouds","2021-08-30 00:00:00","2021-08-27 00:00:00"),
(802,2643743,285.81,"Clouds","2021-08-30 03:00:00","2021-08-27 00:00:00"),
(802,2643743,285.78,"Clouds","2021-08-30 06:00:00","2021-08-27 00:00:00"),
(803,2643743,290.54,"Clouds","2021-08-30 09:00:00","2021-08-27 00:00:00"),
(802,2643743,295.15,"Clouds","2021-08-30 12:00:00","2021-08-27 00:00:00"),
(800,2643743,295.95,"Clear","2021-08-30 15:00:00","2021-08-27 00:00:00"),
(800,2643743,292.39,"Clear","2021-08-30 18:00:00","2021-08-27 00:00:00"),
(800,2643743,288.18,"Clear","2021-08-30 21:00:00","2021-08-27 00:00:00"),
(800,2643743,286.28,"Clear","2021-08-31 00:00:00","2021-08-27 00:00:00"),
(801,2643743,285.06,"Clouds","2021-08-31 03:00:00","2021-08-27 00:00:00"),
(801,2643743,284.46,"Clouds","2021-08-31 06:00:00","2021-08-27 00:00:00"),
(801,2643743,288.5,"Clouds","2021-08-31 09:00:00","2021-08-27 00:00:00"),
(800,2643743,293.24,"Clear","2021-08-31 12:00:00","2021-08-27 00:00:00"),
(800,2643743,294.49,"Clear","2021-08-31 15:00:00","2021-08-27 00:00:00"),
(800,2643743,291.41,"Clear","2021-08-31 18:00:00","2021-08-27 00:00:00"),
(800,2643743,287.44,"Clear","2021-08-31 21:00:00","2021-08-27 00:00:00"),
(800,2643743,285.86,"Clear","2021-09-01 00:00:00","2021-08-27 00:00:00"),
(804,2643743,286.28,"Clouds","2021-09-01 03:00:00","2021-08-27 00:00:00"),
(804,2643743,286.17,"Clouds","2021-09-01 06:00:00","2021-08-27 00:00:00"),
(804,2643743,287.1,"Clouds","2021-09-01 09:00:00","2021-08-27 00:00:00"),
(804,2643743,289.17,"Clouds","2021-09-01 12:00:00","2021-08-27 00:00:00"),
(802,2643743,293.71,"Clouds","2021-09-01 15:00:00","2021-08-27 00:00:00"),
(803,2988507,294.32,"Clouds","2021-08-27 18:00:00","2021-08-27 00:00:00"),
(803,2988507,292.76,"Clouds","2021-08-27 21:00:00","2021-08-27 00:00:00"),
(802,2988507,289.54,"Clouds","2021-08-28 00:00:00","2021-08-27 00:00:00"),
(800,2988507,285.8,"Clear","2021-08-28 03:00:00","2021-08-27 00:00:00"),
(802,2988507,286.86,"Clouds","2021-08-28 06:00:00","2021-08-27 00:00:00"),
(804,2988507,288.51,"Clouds","2021-08-28 09:00:00","2021-08-27 00:00:00"),
(804,2988507,291.04,"Clouds","2021-08-28 12:00:00","2021-08-27 00:00:00"),
(804,2988507,291.98,"Clouds","2021-08-28 15:00:00","2021-08-27 00:00:00"),
(803,2988507,291.61,"Clouds","2021-08-28 18:00:00","2021-08-27 00:00:00"),
(804,2988507,290.06,"Clouds","2021-08-28 21:00:00","2021-08-27 00:00:00"),
(803,2988507,287.1,"Clouds","2021-08-29 00:00:00","2021-08-27 00:00:00"),
(801,2988507,285.87,"Clouds","2021-08-29 03:00:00","2021-08-27 00:00:00"),
(801,2988507,285.79,"Clouds","2021-08-29 06:00:00","2021-08-27 00:00:00"),
(802,2988507,289.23,"Clouds","2021-08-29 09:00:00","2021-08-27 00:00:00"),
(803,2988507,293.87,"Clouds","2021-08-29 12:00:00","2021-08-27 00:00:00"),
(804,2988507,294.14,"Clouds","2021-08-29 15:00:00","2021-08-27 00:00:00"),
(804,2988507,291.68,"Clouds","2021-08-29 18:00:00","2021-08-27 00:00:00"),
(802,2988507,289.18,"Clouds","2021-08-29 21:00:00","2021-08-27 00:00:00"),
(803,2988507,288.33,"Clouds","2021-08-30 00:00:00","2021-08-27 00:00:00"),
(804,2988507,287.19,"Clouds","2021-08-30 03:00:00","2021-08-27 00:00:00"),
(804,2988507,288.03,"Clouds","2021-08-30 06:00:00","2021-08-27 00:00:00"),
(804,2988507,289.94,"Clouds","2021-08-30 09:00:00","2021-08-27 00:00:00"),
(804,2988507,292.44,"Clouds","2021-08-30 12:00:00","2021-08-27 00:00:00"),
(804,2988507,295.07,"Clouds","2021-08-30 15:00:00","2021-08-27 00:00:00"),
(804,2988507,293.41,"Clouds","2021-08-30 18:00:00","2021-08-27 00:00:00"),
(800,2988507,290.9,"Clear","2021-08-30 21:00:00","2021-08-27 00:00:00"),
(800,2988507,288.48,"Clear","2021-08-31 00:00:00","2021-08-27 00:00:00"),
(800,2988507,286.97,"Clear","2021-08-31 03:00:00","2021-08-27 00:00:00"),
(800,2988507,286.34,"Clear","2021-08-31 06:00:00","2021-08-27 00:00:00"),
(800,2988507,291.3,"Clear","2021-08-31 09:00:00","2021-08-27 00:00:00"),
(800,2988507,295.66,"Clear","2021-08-31 12:00:00","2021-08-27 00:00:00"),
(801,2988507,297.06,"Clouds","2021-08-31 15:00:00","2021-08-27 00:00:00"),
(802,2988507,294.5,"Clouds","2021-08-31 18:00:00","2021-08-27 00:00:00"),
(801,2988507,290.9,"Clouds","2021-08-31 21:00:00","2021-08-27 00:00:00"),
(800,2988507,288.1,"Clear","2021-09-01 00:00:00","2021-08-27 00:00:00"),
(800,2988507,286.52,"Clear","2021-09-01 03:00:00","2021-08-27 00:00:00"),
(800,2988507,285.75,"Clear","2021-09-01 06:00:00","2021-08-27 00:00:00"),
(800,2988507,290.6,"Clear","2021-09-01 09:00:00","2021-08-27 00:00:00"),
(800,2988507,295.33,"Clear","2021-09-01 12:00:00","2021-08-27 00:00:00"),
(800,2988507,296.79,"Clear","2021-09-01 15:00:00","2021-08-27 00:00:00"),
(804,524901,291.98,"Clouds","2021-08-27 18:00:00","2021-08-27 00:00:00");

