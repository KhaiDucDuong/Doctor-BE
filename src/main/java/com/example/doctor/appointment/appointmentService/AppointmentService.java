package com.example.doctor.appointment.appointmentService;

import com.example.doctor.account.Account;

import com.example.doctor.appointment.Appointment;
import com.example.doctor.appointment.appiontmentRepository.IAppointmentRepository;
import com.example.doctor.schedule.Schedule;
import com.example.doctor.patient.patientService.PatientService;
import com.example.doctor.schedule.scheduleService.scheduleService;
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
    @Autowired
    private scheduleService scheduleService;

    public AppointmentService(IAppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment addAppointment(Appointment appointment) {
        scheduleService.setAppointmentFlagByScheduleId(appointment.getScheduleId());
        return repository.save(appointment);
    }
    public List<Appointment> getAppointmentByPatientId(ObjectId patientId){return repository.findAppointmentByPatientId(patientId);}

}
