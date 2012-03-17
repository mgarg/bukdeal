drop database bukdb;
create database bukdb;
use bukdb;

create table user(
  id binary(16) primary key,
  name char(32),
  username char(16),
  password char(16),
  mobile char(16),
  email varchar(512) 
);


CREATE TABLE `deal` (
  `id` binary(16) NOT NULL,
  `userid` binary(16) DEFAULT NULL,
  `name` varchar(4000) DEFAULT NULL,
  `author` varchar(4000) DEFAULT NULL,
  `edition` varchar(4000) DEFAULT NULL,
  `publisher` varchar(512) DEFAULT NULL,
  `status` varchar(512) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT 0.0,
  `image` varbinary(10000000) DEFAULT NULL, 
  PRIMARY KEY (`id`),
  FULLTEXT KEY `name` (`name`,`author`,`publisher`)
) ENGINE=MyISAM;

INSERT INTO deal(id,name,author) VALUES('1','operating Systems','galvin');
INSERT INTO deal(id,name,author) VALUES('2','software engineering','pressman');
INSERT INTO deal(id,name,author) VALUES('3',"programming paradigms","pratt");
INSERT INTO deal(id,name,author) VALUES('4',"Algorithms","cormen");
INSERT INTO deal(id,name,author) VALUES('5',"differential equation","kreyzig");

INSERT INTO user(id,username,password) VALUES(1,"mgarg","test1");

