package com.example.doctor.patient.patientService;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorRepository.IdoctorRepository;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientRepository.IpatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PatientService {
    @Autowired
    private IpatientRepository repository;
    public PatientService(IpatientRepository repository) {
        this.repository = repository;
    }


    public Patient addPateint(Patient productype){
        return repository.save(productype);

    }

    public List<Patient> findAllCategory(){
        return repository.findAll();
    }

    public Patient getProductByProductTypeId(String producTypeId){
        return repository.findById(producTypeId).get();

    }

    public String deleteUser(String userId){
        repository.deleteById(userId);
        return userId+" User is deleted";
    }
}
