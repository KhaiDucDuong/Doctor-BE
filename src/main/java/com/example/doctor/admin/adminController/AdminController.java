package com.example.doctor.admin.adminController;

import com.example.doctor.admin.adminService.AdminService;
import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientService.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @GetMapping("/listOfSpecialize")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getAllSpecialize(){
        try{
            return adminService.findAllDoctorSpecialize();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/listOfDoctors")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Doctor> getListOfDoctors()
    {
        try{
            return doctorService.findAllDoctor();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/listOfPatients")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Patient> getListOfPatients()
    {
        try{
            return patientService.findAllPatient();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
