package com.team.SMS.bean;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Grade {

    //年级信息
    private Integer id;
    private String name;
    private String introducation;
    //年级主任信息
    private String manager;
    private String email;
    private String telephone;

}