package com.example.doctor.account;

import com.example.doctor.role.Roles;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
    private ObjectId _id;
    private String loginName;
    private String password;
    private ObjectId userId;
    private Boolean isdeleted;
    @Getter
    @DBRef
    private Set<Roles> roles = new HashSet<>();

}
