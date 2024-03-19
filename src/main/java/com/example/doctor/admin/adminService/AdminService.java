package com.example.doctor.admin.adminService;

import com.example.doctor.doctor.doctorRepository.IdoctorRepository;
import com.example.doctor.patient.patientRepository.IpatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class AdminService {
    @Autowired
    private IdoctorRepository idoctorRepository;

    public List<String> findAllDoctorSpecialize(){
        return idoctorRepository.findAllSpecialize();
    }
}
