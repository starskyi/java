create database BOOK
use BOOK
create table tb_user(
id int primary key identity(1,1),
username varchar(32) unique not null,
password varchar(32) not null,
manager int check(manager in (0,1))
)
create table books(
id int primary key identity(1,1),
name varchar(32) not null,
author varchar(32) not null
)
insert into tb_user values('zhangsan','123456',0),('admin','admin', 1)
insert into books values('C语言程序设计', '林建秋'),('TCPIP详解','凯文')