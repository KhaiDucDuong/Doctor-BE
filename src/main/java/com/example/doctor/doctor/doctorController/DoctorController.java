package com.example.doctor.doctor.doctorController;

import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentService.DepartmentService;
import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/createDoctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor createProductType(@RequestBody Doctor doctor){
        try {
            doctor.setAvailableFlag(true);
            return doctorService.addDoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
