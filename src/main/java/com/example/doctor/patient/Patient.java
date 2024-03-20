package com.example.doctor.patient;

import com.example.doctor.role.Roles;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
    private String fullname;
    private String phoneNumber;
    private String email;
    private Date dateOfbirth;
    private Boolean gender;
    private Boolean hasAppointment;
}
