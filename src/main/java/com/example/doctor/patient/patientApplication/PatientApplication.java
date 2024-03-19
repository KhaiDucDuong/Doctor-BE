package com.example.doctor.patient.patientApplication;
import com.example.doctor.account.accountService.AccountService;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientService.PatientService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PatientApplication {
    @Autowired
    private PatientService patientService;
    @Autowired
    private AccountService accountService;
    public Patient createPatient(Patient fullname) throws Exception {
        //validate data
        if (StringUtils.isEmpty(fullname.getFullname())) {
            throw new Exception("Full name can not be not empty");
        }
        else if (accountService.getAccountByUserID(fullname.get_id())==null)
        {
            throw new Exception("Patient has been created");
        }
        return patientService.addPatient(fullname);
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