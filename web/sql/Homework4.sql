# Copyright 2016 Dominic Vernazza and Tyler Young
DROP DATABASE IF EXISTS Homework4;
CREATE DATABASE IF NOT EXISTS Homework4;
CREATE TABLE IF NOT EXISTS Homework4.patron
(
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
email_address VARCHAR(40) NOT NULL,
book_title VARCHAR(40) NOT NULL,
due_date DATE NOT NULL,
overdue VARCHAR(10)
);








