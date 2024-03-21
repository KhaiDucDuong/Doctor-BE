package com.example.doctor.appointment.appointmentService;

import com.example.doctor.account.Account;

import com.example.doctor.appointment.Appointment;
import com.example.doctor.appointment.appiontmentRepository.IAppointmentRepository;
import com.example.doctor.patient.patientService.PatientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AppointmentService {
    @Autowired
    private IAppointmentRepository repository;
    @Autowired
    private PatientService patientService;

    public AppointmentService(IAppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment addAppointment(Appointment appointment) {
        return repository.save(appointment);

    }
    public List<Appointment> getAppointmentByPatientId(ObjectId patientId){return repository.findAppointmentByPatientId(patientId);}

}
