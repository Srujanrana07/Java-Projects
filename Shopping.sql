CREATE DATABASE IF NOT EXISTS store;
USE store;

create TABLE IF NOT exists user (
    name VARCHAR(50),
    mobno VARCHAR(50),
    username VARCHAR(50),
    password VARCHAR(50),
	UserUID varchar(4),
    LastPayment varchar(20),
    Wallet double(10,2)
);


CREATE TABLE if not exists admin (
    name VARCHAR(50),
    mobno VARCHAR(50),
    username VARCHAR(50),
    password VARCHAR(50),
    UID VARCHAR(50)
);

insert into user(name, mobno, username, password,UserUID,LastPayment,Wallet) VALUES
("srujan", "1234567890", "srujan", "srujan","S100","0","1000"),
("deba", "1234567890", "deba", "deba","D100","0","1000");


INSERT INTO admin (name, mobno, username, password, UID) VALUES
("srujan", "1234567890", "srujan", "srujan", "S10");

SELECT * FROM user;
SELECT * FROM admin;