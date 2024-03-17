package com.example.doctor.appointment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment implements Serializable {
    private ObjectId _id;
    private ObjectId patientId;
    private Date date;
    private ObjectId scheduleId;
    private String SymptomDescription;
    private Integer status;
}
