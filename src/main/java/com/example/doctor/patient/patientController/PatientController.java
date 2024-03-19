package com.example.doctor.patient.patientController;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import com.example.doctor.patient.Patient;
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
@CrossOrigin(origins = "*")

public class PatientController {
    @Autowired
    private PatientService departmentServiceTypeService;
    @Autowired
    private HttpServletRequest request;
    public PatientController(PatientService productTypeApplication) {
        this.departmentServiceTypeService = productTypeApplication;
    }
    @GetMapping("/info")
    public String getUserInfo() {
        // Lấy userId từ session
        HttpSession session = request.getSession(false);
        if (session != null) {
            ObjectId userId = (ObjectId) session.getAttribute("userId");
            if (userId != null) {
                // Sử dụng userId để lấy thông tin người dùng từ cơ sở dữ liệu
                Patient userInfo = departmentServiceTypeService.getPatientByPatientId(String.valueOf(userId));
                if (userInfo != null) {
                    return "User Information: " + userInfo.toString();
                }
            }
        }
        return "User information not found";
    }
    @GetMapping("/allPatients")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Patient> allPatients() {
        try {
            return  departmentServiceTypeService.findAllPatient();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }

    @GetMapping("/patient_{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Patient  getPatient(@Valid @PathVariable("id") String id){
        return departmentServiceTypeService.getPatientByPatientId(id);
    }
}
