package com.example.doctor.department.departmentController;

import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentApplication.DepartmentApplication;
import com.example.doctor.department.deparmentService.DepartmentService;
import com.example.doctor.doctor.Doctor;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
public class DeparmentController {
    @Autowired
    private DepartmentService departmentService;
    private final DepartmentApplication departmentApplication;

    public DeparmentController(DepartmentApplication productTypeApplication) {
        this.departmentApplication = productTypeApplication;
    }

    @SneakyThrows
    @PostMapping("/createDepartment")
    @ResponseStatus(HttpStatus.CREATED)
    public Department createProductType(@RequestBody Department departmentName) {
        try {
            departmentName.setAvailableFlag(true);
            departmentName.setIsDeleted(false);
            return departmentApplication.createDepartment(departmentName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) throws Exception {
        try {
            department.setAvailableFlag(true);
            department.setIsDeleted(false);
            return departmentApplication.updateDepartment(department);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/deleteDepartment")
    public Department deleteDepartment(@RequestBody Department department) {
        try {
            department.setAvailableFlag(false);
            department.setIsDeleted(true);
            return departmentService.updateDepartment(department);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/allDepartments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Department> getDepartments() {
        try {
            return departmentService.findAllDepartment();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search/{data}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Department> SearchDepartment(@Valid @PathVariable("data") String data) {
        data = data.replace("+", " ");
        return departmentService.searchDepartment(data);
    }
}
