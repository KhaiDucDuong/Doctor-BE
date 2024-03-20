package com.example.doctor.doctor.doctorService;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorRepository.IdoctorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Doctor updateDoctor(Doctor doctor){
        if(repository.existsById(String.valueOf(doctor.get_id()))){
            return repository.save(doctor);
        }
        else{
            throw new RuntimeException("Doctor with ID " + doctor.get_id() + " does not exist.");
        }
    }

    public List<Doctor> findAllDoctor(){
        return repository.findAll();
    }

    public Doctor getDoctorByDoctorId(String doctorId){
        return repository.findById(doctorId).get();
    }
    public ObjectId getDepartmentByDoctorId(String doctorId){
        return repository.findById(doctorId).get().getDepartmentId();
    }
    public List<Doctor> getdoctorByDoctorName(String Fullname){
        return repository.findByFullname(Fullname);
    }
    public String deleteUser(String userId){
        repository.deleteById(userId);
        return userId+" User is deleted";
    }
    public List<Doctor> searchDoctors(String data){
        return repository.SearchDoctorsReg(data);
    }
    public List<Doctor> findDoctorsByDepartmentId(String id){
        ObjectId departmentId = new ObjectId(id);
        return repository.findDoctorByDepartmentId(departmentId);
    }
}
