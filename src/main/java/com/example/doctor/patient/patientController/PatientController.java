package com.example.doctor.patient.patientController;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientService.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService departmentServiceTypeService;
    public PatientController(PatientService productTypeApplication) {
        this.departmentServiceTypeService = productTypeApplication;
    }
    private DoctorService doctorService;

    @PostMapping("/createPatient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient productType){
        try {
            return departmentServiceTypeService.addPateint(productType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/doctors/{fullname}")
    @PostMapping("/makeAppointment1")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient makeAppointment1(@RequestBody Patient productType){
        try {
            List<Doctor> listDoctor = doctorService.findAllDocter();

            return departmentServiceTypeService.addPateint(productType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
