package com.example.doctor.doctor.doctorApplication;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.function.Predicate;
import java.util.List;
import java.util.Arrays;

@SpringBootApplication
public class DoctorsApplication {
    @Autowired
    private DoctorService doctorService;

    public Doctor createDoctor(Doctor doctor) throws Exception {
        //validate data
        List<Predicate<Doctor>> conditions = Arrays.asList(
                d -> StringUtils.isEmpty(d.getFullname()),
                d -> StringUtils.isEmpty(String.valueOf(d.getGender())),
                d -> StringUtils.isEmpty(String.valueOf(d.getDateOfbirth())),
                d -> StringUtils.isEmpty(String.valueOf(d.getPhoneNumber())),
                d -> StringUtils.isEmpty(String.valueOf(d.getSpecialize()))
        );
        for (Predicate<Doctor> condition : conditions) {
            if (condition.test(doctor)) {
                throw new Exception("Invalid doctor data");
            }
        }
        if (doctorService.getdoctorByDoctorName(doctor.getPhoneNumber()).size() > 0) {
            throw new Exception("Phone number existed");
        }
        return doctorService.addDoctor(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) throws Exception {
        //validate data
        List<Predicate<Doctor>> conditions = Arrays.asList(
                d -> StringUtils.isEmpty(d.getFullname()),
                d -> StringUtils.isEmpty(String.valueOf(d.getGender())),
                d -> StringUtils.isEmpty(String.valueOf(d.getDateOfbirth())),
                d -> StringUtils.isEmpty(String.valueOf(d.getPhoneNumber())),
                d -> StringUtils.isEmpty(String.valueOf(d.getSpecialize()))
        );
        for (Predicate<Doctor> condition : conditions) {
            if (condition.test(doctor)) {
                throw new Exception("Invalid doctor data");
            }
        }
        if (doctorService.getdoctorByDoctorName(doctor.getPhoneNumber()).size() > 0) {
            throw new Exception("Phone number existed");
        }
            return doctorService.updateDoctor(doctor);
    }
}

