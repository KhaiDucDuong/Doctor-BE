package com.example.doctor.appointment.appiontmentRepository;

import com.example.doctor.appointment.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAppointmentRepository extends MongoRepository<Appointment, String> {

}
