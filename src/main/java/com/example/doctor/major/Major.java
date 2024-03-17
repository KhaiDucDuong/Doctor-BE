package com.example.doctor.major;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "majors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Major implements Serializable {
    private ObjectId _id;
    private String majorName;
    private String symptomCure;
    private String bodypart;
}
