create database shop

use shop

create table tb_admin(
	id int identity(1,1) primary key,
	username varchar(64) not null unique,
	password varchar(64) not null
)

create table tb_commodity(
	id int not null identity(1,1) primary key,
	shop varchar(64) not null,
	image varchar(128) not null,
	title varchar(256) not null,
	kind int not null,
	price float not null,
	count int not null,
	repertory int not null
)

create table tb_record(
	id int identity(1,1) primary key,
	uid int not null,
	cid int not null,
	status int not null,
	price float not null
)

create table tb_user(
	id int identity(1,1) primary key,
	username varchar(32) unique not null,
	password varchar(32) not null,
	name varchar(32) not null,
	telephone varchar(32),
	isMerchant int not null,
	sex varchar(32),
	address varchar(128),
	money float default(0.0)
)