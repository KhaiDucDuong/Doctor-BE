package com.example.doctor.command;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class commandRegister {
    private String fullname;
    private String phoneNumber;
    private String email;
    private Date dateOfbirth;
    private Boolean gender;
    private String loginName;
    private String password;
    private String roles;

    public String setRoles(String role) {
        return role;
    }
}
