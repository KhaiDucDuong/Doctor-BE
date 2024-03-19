package com.example.doctor.schedule;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Date;

@Document(collection = "schedules")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
    private ObjectId doctorId;
    private ObjectId deparmentId;
    private String dateOfweek;
    private String startTime;
    private String endTime;
    private Boolean availableFlag;
}
