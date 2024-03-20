package com.example.doctor.patient.patientApplication;
import com.example.doctor.account.accountService.AccountService;
import com.example.doctor.doctor.Doctor;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientService.PatientService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
public class PatientApplication {
    @Autowired
    private PatientService patientService;
    @Autowired
    private AccountService accountService;
    public Patient createPatient(Patient patient) throws Exception {
        //validate data
        List<Predicate<Patient>> conditions = Arrays.asList(
                d -> StringUtils.isEmpty(d.getFullname()),
                d -> StringUtils.isEmpty(d.getPhoneNumber()),
                d -> StringUtils.isEmpty(d.getEmail()),
                d -> StringUtils.isEmpty(String.valueOf(d.getDateOfbirth())),
                d -> StringUtils.isEmpty(String.valueOf(d.getGender()))
        );
        for (Predicate<Patient> condition : conditions) {
            if (condition.test(patient)) {
                throw new Exception("Invalid doctor data");
            }
        }
        if (accountService.getAccountByUserID(patient.get_id()).size()>0)
        {
            throw new Exception("Patient has been created");
        }
        return patientService.addPatient(patient);
    }
    public Patient updatePatient(Patient patient) throws Exception{
        //validate data
        List<Predicate<Patient>> conditions = Arrays.asList(
                d -> StringUtils.isEmpty(d.getFullname()),
                d -> StringUtils.isEmpty(d.getPhoneNumber()),
                d -> StringUtils.isEmpty(d.getEmail()),
                d -> StringUtils.isEmpty(String.valueOf(d.getDateOfbirth())),
                d -> StringUtils.isEmpty(String.valueOf(d.getGender()))
        );
        for (Predicate<Patient> condition : conditions) {
            if (condition.test(patient)) {
                throw new Exception("Invalid doctor data");
            }
        }
        if (accountService.getAccountByUserID(patient.get_id()).size()>0)
        {
            throw new Exception("Patient has been created");
        }
        return patientService.updatePatient(patient);
    }
    public List<Patient> findAllPatient(){
        return  patientService.findAllPatient();
    }
    public Patient getPatientById(String id) throws Exception{
        Patient patient =  patientService.getPatientById(id);
        if (patient == null) {
            throw new Exception("Không có patient");
        }
        else return patient;
    }
}