package com.example.doctor.patient.patientService;

import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientRepository.IpatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class PatientService {
    @Autowired
    private IpatientRepository repository;
    public PatientService(IpatientRepository repository) {
        this.repository = repository;
    }


    public Patient addPatient(Patient patient){
        return repository.save(patient);

    }

    public List<Patient> findAllCategory(){
        return repository.findAll();
    }

    public Patient getPatientByPatientId(String producTypeId){
        return repository.findById(producTypeId).get();

    }
    public List<Patient> getPatientByPatientName(String Fullname){

        return repository.findByFullname(Fullname);
    }
    public Patient getPatientById(String id){
        return repository.findById(id).get();
    }

    public List<Patient> findAllPatient(){
        return repository.findAll();
    }
    public String deleteUser(String userId){
        repository.deleteById(userId);
        return userId+" User is deleted";
    }
}
