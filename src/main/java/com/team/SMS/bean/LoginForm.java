package com.team.SMS.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;


}
