create database if not exists study;
create table if not exists study.t_audit
(
    `id`         bigint        NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `operation`  varchar(20)   NOT NULL,
    `args`       varchar(4000) NOT NULL,
    `createtime` timestamp     NOT NULL DEFAULT current_timestamp
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

delimiter $
drop procedure if exists study.`createTablesWithIndex`;
create procedure study.`createTablesWithIndex`()
begin
    declare `@i` int(2);
    declare `@baseSql` varchar(2000);
    set `@i` = 0;
    while `@i` < 4 do
    set @baseSql = concat('create table if not exists study.t_order', `@i`, '(
                    `id`          bigint    NOT NULL UNIQUE KEY,
                    `status`      varchar(10)    NOT NULL,
                    `pay_type`    int(2)    NOT NULL,
                    `create_time` timestamp NOT NULL DEFAULT current_timestamp,
                    `update_time` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
                ) ENGINE = INNODB
                  DEFAULT CHARSET = utf8;');
    prepare stmt from @baseSql;
    execute stmt;
    SET `@i` = `@i` + 1;
    end while;
end $
delimiter ;
call study.createTablesWithIndex();