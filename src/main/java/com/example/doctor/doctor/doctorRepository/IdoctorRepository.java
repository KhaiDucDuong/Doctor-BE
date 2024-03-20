package com.example.doctor.doctor.doctorRepository;


import com.example.doctor.doctor.Doctor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface  IdoctorRepository extends MongoRepository<Doctor,String>, CustomIdoctorRepository {
    List<Doctor> findByFullname(String doctor);
    List<Doctor> findByFullnameIgnoreCase(String fullname);
    @Query("{ 'fullname' : { '$regex' : ?0 , $options: 'i'}}")
    List<Doctor> SearchDoctorsReg(String fullname);

    @Query(value = "{'specialize' : {$exists: true}}", fields = "{ 'specialize' : 1}")
    List<String> findAllSpecialize();


    List<Doctor> findDoctorByDepartmentId(ObjectId departmentId);

}
