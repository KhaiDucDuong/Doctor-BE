package com.example.doctor.doctor.doctorController;

import com.example.doctor.department.Department;
import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorApplication.DoctorsApplication;
import com.example.doctor.doctor.doctorService.DoctorService;
import com.example.doctor.patient.Patient;
import jakarta.validation.Valid;
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
            doctor.setIsDeleted(false);
            return doctorApplication.createDoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/updateDoctor")
    public Doctor updateDoctor(@RequestBody Doctor doctor) throws Exception {
        try {
            doctor.setAvailableFlag(true);
            doctor.setIsDeleted(false);
            return doctorApplication.updateDoctor(doctor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/deleteDepartment")
    public Doctor deleteDoctor(@RequestBody Doctor doctor) {
        try {
            doctor.setAvailableFlag(false);
            doctor.setIsDeleted(true);
            return doctorService.updateDoctor(doctor);
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
    @GetMapping("/search/{data}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Doctor> SearchDoctorsReg(@Valid @PathVariable("data") String data){
        data = data.replace("+", " ");
        return doctorService.searchDoctors(data);
    }
}
