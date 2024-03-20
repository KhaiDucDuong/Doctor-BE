package com.example.doctor.doctor;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId accountId;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId departmentId;
    private String fullname;
    private Boolean gender;
    private Date dateOfbirth;
    private String phoneNumber;
    private String specialize;
    private String description;
    private Boolean availableFlag;
    private Boolean isDeleted;
}
