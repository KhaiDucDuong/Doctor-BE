package com.example.doctor.role;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Roles implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
    private String roleName;
    private Boolean isDeleted;
}
