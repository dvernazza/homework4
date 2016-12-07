# Copyright 2016 Dominic Vernazza and Tyler Young
DROP DATABASE IF EXISTS winona;
CREATE DATABASE IF NOT EXISTS winona;
CREATE TABLE IF NOT EXISTS winona.patron
(
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
email_address VARCHAR(40) NOT NULL,
book_title VARCHAR(40) NOT NULL,
due_date DATE NOT NULL,
overdue VARCHAR(10)
);








