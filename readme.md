# my-SMS

## 前言
> 该项目是对
> 复现一个基于SSM的学生管理系统
>
> github链接： [my-SMS](https://github.com/kleinlsl/my-SMS) 
>
> 作者： *`黄宇辉`*  

## 基于 SSM 的简单学生管理系统 

> 该存储库是对*`黄宇辉`* 的[sms-ssm](https://github.com/YUbuntu0109/sms-ssm) 进行复现，旨在学习如何使用SSM框架。
> *sms-ssm*项目信息：
> >项目简介：*一个基于SSM的学生管理系统 : 代码注释详细,逻辑结构清晰,非常具有参考,学习价值哟 !*
>
> >🔑*数据库中默认的管理员身份信息 : 账户名 : `root` , 密码 `123456`*
>
> >项目原地址：[sms-ssm](https://github.com/YUbuntu0109/sms-ssm) 
>
> >项目展示链接：[here](http://39.99.140.59:8000/sms/)



## 用户权限介绍

- *管理员 : 具有所有管理模块的操控权限*
- *教师 : 仅具有学生信息管理模块的所有权限,且在教师信息管理模块中只具有查询及添加信息的权限*
- *学生 : 仅具有学生信息管理模块的查询及添加信息的权限*

## 数据库表

```sql
create table tb_admin
(
    id            int auto_increment
        constraint `PRIMARY`
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
        constraint `PRIMARY`
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
    constraint `PRIMARY`
        primary key (id, name)
)
    comment '年级信息表';

create table tb_student
(
    id            int auto_increment
        constraint `PRIMARY`
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
        constraint `PRIMARY`
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


```

![表关系](https://raw.githubusercontent.com/YUbuntu0109/SSM-SMS/master/demonstration_picture/SMS-Database-ER.png)



## 其他信息

> 其他信息参照： [sms-ssm](https://github.com/YUbuntu0109/sms-ssm) 
>
> 

## 详细项目功能

> 请通过使用进行体验：[demo](http://39.99.140.59:8000/sms/)


## 复现演示地址

> [mySMS](http://39.99.140.59:8000/mySMS/)<br>
> 用户名：root
> 密  码：123456