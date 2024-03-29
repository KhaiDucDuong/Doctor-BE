package com.example.doctor.doctor.doctorService;

import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentRepository.IdeparmentRepository;
import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorRepository.IdoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;
@Component
public class DoctorService {
    @Autowired
    private IdoctorRepository repository;
    public DoctorService(IdoctorRepository repository) {
        this.repository = repository;
    }


    public Doctor addDoctor(Doctor doctor){
        return repository.save(doctor);

    }

    public List<Doctor> findAllDocter(){
        return repository.findAll();
    }

    public Doctor getProductByProductTypeId(String producTypeId){
        return repository.findById(producTypeId).get();

    }

    public String deleteUser(String userId){
        repository.deleteById(userId);
        return userId+" User is deleted";
    }
}
