create database if not exists school;

use school;

create table if not exists students(
    id int(10) auto_increment not null primary key ,
    name varchar(25) not null ,
    age int(25) not null,
    createTime datetime not null ,
    updateTime datetime not null,
    status int null comment '状态（1置顶 0不置顶）'
)character set = utf8 ENGINE = InnoDB comment '学生信息表';
