package com.example.doctor.department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department implements Serializable {
    private ObjectId _id;
    private String departmentName;
    private String location;
    private String openTime;
    private String closeTime;
    private Boolean availableFlag;
}
