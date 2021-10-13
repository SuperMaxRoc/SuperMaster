drop database school;
create database if not exists school;

use school;

drop table if exists students;

#创建学生表
create table if not exists students
(
    student_id                    varchar(250) not null primary key,
    student_name                  varchar(250) not null comment '学生姓名',
    student_number                varchar(250) not null comment '学生学号',
    student_card_id               varchar(250) not null comment '学生身份证',
    student_sex                   varchar(250) null comment '学生性别',
    student_age                   int(25)      null comment '学生年龄',
    student_grade                 varchar(250) null comment '学生年级ID',
    student_grade_name            varchar(250) null comment '学生年级name',
    student_class                 varchar(250) null comment '学生班级ID',
    student_class_name            varchar(250) null comment '学生班级name',
    student_email                 varchar(250) null comment '学生电子邮件',
    student_status                varchar(250) null comment '学生状态',
    student_birthday              varchar(250) null comment '学生生日',
    student_address               varchar(250) null comment '学生家庭住址',
    student_phone                 varchar(250) null comment '学生电话',
    student_guardian_id           varchar(250) null comment '学生监护人ID',
    student_guardian_name         varchar(250) null comment '学生监护人姓名',
    student_guardian_phone        varchar(250) null comment '学生监护人电话',
    student_guardian_relationship varchar(250) null comment '学生监护人关系',
    student_admission_time        date         null comment '学生入学时间',
    student_leave_time            date         null comment '学生毕业时间',
    student_Registered_residence  varchar(250) null comment '学生户籍地',
    remark                        text         null comment '备注',
#---------------------------------------------------------------------------------------------
    create_by                     varchar(250) null comment '创建人',
    create_time                   datetime     null comment '创建时间',
    update_by                     varchar(250) null comment '更新人',
    update_time                   datetime     null comment '更新时间',
    delete_by                     varchar(250) null comment '删除人',
    delete_time                   datetime     null comment '删除时间',
    delete_status                 boolean      null comment '删除状态'
) character set = utf8
  ENGINE = InnoDB comment '学生信息表';

drop table if exists school.guardian;

#创建监护人信息表
create table if not exists guardian
(
    guardian_id                    varchar(250) not null primary key,
    guardian_name                  varchar(250) not null comment '监护人姓名',
    guardian_number                varchar(250) not null comment '监护人学号',
    guardian_card_id               varchar(250) not null comment '监护人身份证',
    guardian_sex                   varchar(250) null comment '监护人性别',
    guardian_age                   int(25)      null comment '监护人年龄',
    guardian_address               varchar(250) null comment '监护人家庭住址',
    guardian_Registered_residence  varchar(250) null comment '监护人户籍地',
    guardian_phone                 varchar(250) null comment '监护人电话',
    guardian_student_id            varchar(250) not null comment '被监护学生Id',
    guardian_student_name          varchar(250) not null comment '被监护学生name',
    guardian_guardian_relationship varchar(250) null comment '监护人与被监护人关系',
#----------------------------------------------------------------------------------------------------
    create_by                      varchar(250) null comment '创建人',
    create_time                    datetime     null comment '创建时间',
    update_by                      varchar(250) null comment '更新人',
    update_time                    datetime     null comment '更新时间',
    delete_by                      varchar(250) null comment '删除人',
    delete_time                    datetime     null comment '删除时间',
    delete_status                  boolean      null comment '删除状态'
) character set = utf8
  ENGINE = InnoDB comment '监护人信息表';
