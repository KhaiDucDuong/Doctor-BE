package com.example.doctor.doctor.doctorApplication;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorsApplication {
    @Autowired
    private DoctorService doctorService;
    public Doctor createDoctor(Doctor fullname) throws Exception {
        //validate data
        if (StringUtils.isEmpty(fullname.getFullname())) {
            throw new Exception("Full name can not be not empty");
        }
        else if (doctorService.getdoctorByDoctorName(fullname.getAccountId().toString())==null)
        {
            throw new Exception("Doctor has been created");
        }
        return doctorService.addDoctor(fullname);
    }
}
