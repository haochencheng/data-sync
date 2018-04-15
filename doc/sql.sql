CREATE DATABASE data_sync;

CREATE TABLE half_year_data_statistical
(
    id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    statistical_date DATE,
    area VARCHAR(255),
    total_amount INT(11) NOT NULL
);