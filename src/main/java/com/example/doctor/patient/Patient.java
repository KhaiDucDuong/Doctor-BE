package com.example.doctor.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
@Document(collection = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient implements Serializable {
    private ObjectId _id;
    private ObjectId accountId;
    private String fullname;
    private String phoneNumber;
    private String email;
    private Date dateOfbirth;
    private Boolean gender;
    private Boolean hasAppointment;
}
