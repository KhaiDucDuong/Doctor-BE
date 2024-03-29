package com.example.doctor.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor implements Serializable {
    private ObjectId _id;
    private ObjectId accountId;
    private ObjectId deparmentId;
    private String fullname;
    private Boolean gender;
    private Date dateOfbirth;
    private String phoneNumber;
    private String specialize;
    private String description;
    private Boolean availableFlag;
}
