package com.example.doctor.doctor.doctorRepository;

import com.example.doctor.department.Department;
import com.example.doctor.doctor.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IdoctorRepository extends MongoRepository<Doctor,String> {
    List<Doctor> findByFullname(String doctor);

    @Query("select distinct d.specialize from Doctor d")
    List<String> findAllSpecialize();
}
