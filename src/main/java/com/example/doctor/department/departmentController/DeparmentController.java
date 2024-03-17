package com.example.doctor.department.departmentController;

import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentApplication.DepartmentApplication;
import com.example.doctor.department.deparmentService.DepartmentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
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
}
