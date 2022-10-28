DROP TABLE IF EXISTS emp;

CREATE TABLE emp (
  employeeId int NOT NULL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  hiredate datetime DEFAULT NULL,
  PRIMARY KEY (employeeId)
);

INSERT INTO emp VALUES (1500,'길동','홍','hong@gildong.com','2021-04-27 16:05:25'),(1501,'길동','박','park@gildong.com','2021-04-30 18:41:31'),(1502,'길동','이','lee@gildong.com','2020-05-05 00:00:00');