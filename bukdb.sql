drop database bukdb;
create database bukdb;
use bukdb;

create table user(
  id binary(128) primary key,
  name char(32),
  username char(16),
  password char(16),
  mobile char(16),
  email varchar(512) 
);

create table deal(
  id binary(128) primary key,
  userid binary(128),
  name char(16),
  author char(16),
  edition char(8),
  publisher varchar(512),
  status varchar(512),
  price decimal(6,2) 
);

INSERT INTO deal(id,name,author) VALUES('1','operating Systems','galvin');
INSERT INTO deal(id,name,author) VALUES('2','software engineering','pressman');
INSERT INTO deal(id,name,author) VALUES('3',"programming paradigms","pratt");
INSERT INTO deal(id,name,author) VALUES('4',"Algorithms","cormen");
INSERT INTO deal(id,name,author) VALUES('5',"differential equation","kreyzig");


