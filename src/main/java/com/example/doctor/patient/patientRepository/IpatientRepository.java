package com.example.doctor.patient.patientRepository;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.patient.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IpatientRepository extends MongoRepository<Patient,String> {
    List<Patient> findByFullname(String patient);
}
