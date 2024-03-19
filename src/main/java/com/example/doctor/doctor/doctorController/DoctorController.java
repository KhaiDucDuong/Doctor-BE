package com.example.doctor.doctor.doctorController;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorApplication.DoctorsApplication;
import com.example.doctor.doctor.doctorService.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    private DoctorsApplication doctorApplication;
    public DoctorController(DoctorsApplication doctorApplication) {
        this.doctorApplication = doctorApplication;
    }

    @PostMapping("/createDoctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor createProductType(@RequestBody Doctor doctor){
        try {
            doctor.setAvailableFlag(true);
            return doctorApplication.createDoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/allDoctors")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Doctor> getDoctors(){
        try {
            return doctorService.findAllDoctor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
