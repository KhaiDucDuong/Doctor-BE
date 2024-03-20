package com.example.doctor.patient.patientController;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientApplication.PatientApplication;
import com.example.doctor.patient.patientService.PatientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(
        origins = {"http://localhost:3000", "http://127.0.0.1:3000"},
        allowCredentials = "true"
)
public class PatientController {
    @Autowired
    private PatientService patientService;
    private PatientApplication patientApplication;
    @Autowired
    private HttpServletRequest request;
    public PatientController(PatientService productTypeApplication) {
        this.patientService = productTypeApplication;
    }
    @PostMapping("/createPatient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient){
        try {
            patient.setIsDeleted(false);
            return patientApplication.createPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/updatePatient")
    public Patient updatePatient(@RequestBody Patient patient) throws Exception {
        try {
            return patientApplication.updatePatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/deletePatient")
    public Patient deletePatient(@RequestBody Patient patient) {
        try {
            patient.setIsDeleted(true);
            return patientService.updatePatient(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/info")
    public Patient getUserInfo() {
        // Lấy userId từ session
        HttpSession session = request.getSession(false);
        if (session != null) {
            ObjectId userId = (ObjectId) session.getAttribute("userId");
            if (userId != null) {
                // Sử dụng userId để lấy thông tin người dùng từ cơ sở dữ liệu
                Patient userInfo = patientService.getPatientByPatientId(String.valueOf(userId));
                if (userInfo != null) {
                    return userInfo;
                }
            }
        }
        return null;
    }
    @GetMapping("/allPatients")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Patient> allPatients() {
        try {
            return  patientService.findAllPatient();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }

    @GetMapping("/patient_{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Patient  getPatient(@Valid @PathVariable("id") String id){
        return patientService.getPatientByPatientId(id);
    }
}
