create database if not exists study;
create table if not exists study.t_student
(
    `id`      bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`    varchar(20)  NOT NULL,
    `age`     int(3)       NOT NULL,
    `address` varchar(256) NOT NULL DEFAULT ""
) ENGINE = INNODB
  DEFAULT CHARSET = "utf8";