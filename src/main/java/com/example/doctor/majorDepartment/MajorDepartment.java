package com.example.doctor.majorDepartment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "majorDes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MajorDepartment implements Serializable {
    private ObjectId _id;
    private ObjectId majorId;
    private ObjectId departmentId;

}
