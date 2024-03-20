package com.example.doctor.department.deparmentRepository;

import com.example.doctor.department.Department;
import com.example.doctor.doctor.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeparmentRepository extends MongoRepository<Department,String> {
    List<Department> findByDepartmentName(String departmentName);

    @Query("{ 'departmentName' : { '$regex' : ?0 , $options: 'i'}}")
    List<Department> SearchDepartment(String departmentName);
}
