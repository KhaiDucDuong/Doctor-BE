package com.example.doctor.department.deparmentService;

import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentRepository.IdeparmentRepository;
import com.example.doctor.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.function.Predicate;
import java.util.List;
import java.util.Arrays;
@Component
public class DepartmentService {
    @Autowired
    private IdeparmentRepository repository;
    public DepartmentService(IdeparmentRepository repository) {
        this.repository = repository;
    }


    public Department addDepartment(Department departmentName){
        return repository.save(departmentName);

    }
    public Department updateDepartment(Department department) {
        if (repository.existsById(String.valueOf(department.get_id()))) {
            return repository.save(department);
        } else {
            throw new RuntimeException("Department with ID " + department.get_id() + " does not exist.");
        }
    }
    public List<Department> findAllDepartment(){
        return repository.findAll();
    }

    public Department getProductByProductTypeId(String producTypeId){
        return repository.findById(producTypeId).get();
    }

    public List<Department> getdepartmentByDepartmentName(String departmentName){
        return repository.findByDepartmentName(departmentName);
    }

    public String deleteUser(String userId){
        repository.deleteById(userId);
        return userId+" User is deleted";
    }
    public List<Department> searchDepartment(String data){
        return repository.SearchDepartment(data);
    }
}
