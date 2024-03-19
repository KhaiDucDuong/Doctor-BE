package com.example.doctor.doctor.doctorRepository;

import com.example.doctor.doctor.Doctor;

import java.util.List;

public interface CustomIdoctorRepository {
    List<Doctor> searchDoctors(String data);
}