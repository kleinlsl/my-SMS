package com.team.SMS.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Teacher {

    private Integer id;
    private String tno;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String clazz_name;
    private String portrait_path;//存储头像的项目路径

    public Teacher(String name, String clazz_name) {
        this.name = name;
        this.clazz_name = clazz_name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tno='" + tno + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", clazz_name='" + clazz_name + '\'' +
                ", portrait_path='" + portrait_path + '\'' +
                '}';
    }
}
