package com.example.doctor.appointment.appiontmentRepository;

import com.example.doctor.appointment.Appointment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface IAppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAppointmentByPatientId(ObjectId patientId);

}
