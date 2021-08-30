TRUNCATE city;
TRUNCATE weather;
SET FOREIGN_KEY_CHECKS = 1;

insert into city (id, city_name, country, timezone, created_at) values (2643743, "London", "GB", 3600, NOW());
insert into city (id, city_name, country, timezone, created_at) values (524901, "Moscow", "RU", 10800, NOW());
insert into city (id, city_name, country, timezone, created_at) values (2988507, "Paris", "FR", 7200, NOW());