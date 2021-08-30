SET FOREIGN_KEY_CHECKS = 0;
drop table if exists city;
drop table if exists weather;

create table city (
    id int (15) not null,
    city_name varchar (20)  not null,
    country varchar (4) not null,
    timezone int (10) not null,
    created_at datetime default null,
    primary key (id)
);

create table weather (
    ind int (5) not null AUTO_INCREMENT,
    id int (6) not null,
    city_id int (15) not null,
    temp_value decimal (19,2) not null,
    main varchar (20) default null,
    dt timestamp default null,
    created_at datetime default null,
    primary key (ind),
    foreign key (city_id) references city (id)
);

CREATE INDEX weather_id_and_city_id_idx ON weather (ind, city_id);