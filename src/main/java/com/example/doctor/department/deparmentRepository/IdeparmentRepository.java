package com.example.doctor.department.deparmentRepository;

import com.example.doctor.department.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeparmentRepository extends MongoRepository<Department,String> {
    List<Department> findByDepartmentName(String departmentName);
}
