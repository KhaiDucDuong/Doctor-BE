package com.example.doctor.doctor.doctorRepository;

import com.example.doctor.department.Department;
import com.example.doctor.doctor.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IdoctorRepository extends MongoRepository<Doctor,String> {
    List<Doctor> findByFullname(String doctor);
}
