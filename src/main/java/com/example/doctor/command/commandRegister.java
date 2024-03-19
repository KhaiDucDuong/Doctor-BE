package com.example.doctor.command;

import com.example.doctor.role.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @DBRef
    private Set<Roles> roles = new HashSet<>();
}
