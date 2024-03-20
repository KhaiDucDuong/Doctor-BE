package com.example.doctor.command;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;

@Getter
@Setter
public class commandRegisterDoctor {
    private ObjectId deparmentId;
    private String fullname;
    private Boolean gender;
    private Date dateOfbirth;
    private String phoneNumber;
    private String specialize;
    private String description;
    private Boolean availableFlag;
    private String loginName;
    private String password;
    private String roles;

    public String setRoles(String role) {
        return role;
    }
}
