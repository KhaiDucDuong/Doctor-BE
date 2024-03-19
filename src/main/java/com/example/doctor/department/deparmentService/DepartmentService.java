package com.example.doctor.department.deparmentService;

import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentRepository.IdeparmentRepository;
import com.example.doctor.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public List<Department> findAllCategory(){
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
