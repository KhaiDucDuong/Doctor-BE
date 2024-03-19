package com.example.doctor.department.deparmentApplication;

import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentService.DepartmentService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentApplication {
    @Autowired
    private DepartmentService departmentService;
    public Department createDepartment(Department departmentName) throws Exception {
        //validate data
        if (StringUtils.isEmpty(departmentName.getDepartmentName())) {
            throw new Exception("Department name can not be not empty");
        }
        else if (departmentService.getdepartmentByDepartmentName(departmentName.getDepartmentName())==null)
        {
            throw new Exception("Department name has been created");
        }
        return departmentService.addDepartment(departmentName);
    }
}
