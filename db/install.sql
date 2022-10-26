create database if not exists study;
create table if not exists study.t_student
(
    `id`      bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`    varchar(20)  NOT NULL,
    `age`     int(3)       NOT NULL,
    `address` varchar(256) NOT NULL DEFAULT ""
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;
create table if not exists study.t_audit
(
    `id`         bigint        NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `operation`  varchar(20)   NOT NULL,
    `args`       varchar(4000) NOT NULL,
    `createtime` timestamp     NOT NULL DEFAULT current_timestamp
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;