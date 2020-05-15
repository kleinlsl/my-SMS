CREATE SCHEMA `ssm_my_sms` ;

use ssm_my_sms;
create table tb_admin
(
    id            int auto_increment
        primary key,
    name          varchar(15)  not null,
    gender        char         null,
    password      varchar(20)  not null,
    email         varchar(50)  not null,
    telephone     varchar(12)  not null,
    address       varchar(100) not null,
    portrait_path varchar(200) null comment '存储头像的项目路径'
)
    comment '管理员信息表';

create table tb_clazz
(
    id            int auto_increment
        primary key,
    name          varchar(15)  not null,
    number        int(3)       not null,
    introducation varchar(200) not null,
    coordinator   varchar(15)  not null,
    email         varchar(50)  not null,
    telephone     varchar(12)  not null,
    grade_name    varchar(15)  not null
)
    comment '班级信息表';

create index tb_clazz_tb_grade__fk_idx
    on tb_clazz (grade_name);

create table tb_grade
(
    id            int auto_increment,
    name          varchar(15)  not null,
    manager       varchar(15)  not null,
    email         varchar(50)  not null,
    telephone     varchar(12)  not null,
    introducation varchar(200) not null,
    primary key (id, name)
)
    comment '年级信息表';

create table tb_student
(
    id            int auto_increment
        primary key,
    sno           varchar(20)  not null,
    name          varchar(15)  not null,
    gender        char         null,
    password      varchar(20)  not null,
    email         varchar(50)  not null,
    telephone     varchar(12)  not null,
    address       varchar(100) not null,
    introducation varchar(200) null,
    portrait_path varchar(200) null,
    clazz_name    varchar(15)  not null,
    constraint tb_student_sno_uindex
        unique (sno)
)
    comment '学生信息表';

create table tb_teacher
(
    id            int auto_increment
        primary key,
    tno           varchar(20)  not null,
    name          varchar(15)  not null,
    gender        char         null,
    password      varchar(20)  not null,
    email         varchar(50)  not null,
    telephone     varchar(12)  not null,
    address       varchar(100) not null,
    portrait_path varchar(200) null,
    clazz_name    varchar(15)  not null,
    constraint tb_teacher_tno_uindex
        unique (tno)
)
    comment '教师信息表';

INSERT INTO `tb_admin` VALUES (1,'root','男','123456','root@qq.com','15036555458','河南洛阳',NULL);
