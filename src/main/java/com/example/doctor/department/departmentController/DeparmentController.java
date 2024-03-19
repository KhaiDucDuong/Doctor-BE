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
    private DepartmentService departmentServiceTypeService;
    private final DepartmentApplication departmentApplication;

    public DeparmentController(DepartmentApplication productTypeApplication) {
        this.departmentApplication = productTypeApplication;
    }

    @SneakyThrows
    @PostMapping("/createDepartment")
    @ResponseStatus(HttpStatus.CREATED)
    public Department createProductType(@RequestBody Department departmentName){
            departmentName.setAvailableFlag(true);
            return departmentApplication.createDepartment(departmentName);
    }
    @GetMapping("/search/{data}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Department> SearchDepartment(@Valid @PathVariable("data") String data){
        data = data.replace("+", " ");
        return departmentServiceTypeService.searchDepartment(data);
    }
}
