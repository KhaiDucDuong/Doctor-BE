package com.example.doctor.appointment.appointmentService;

import com.example.doctor.account.Account;

import com.example.doctor.appointment.Appointment;
import com.example.doctor.appointment.appiontmentRepository.IAppointmentRepository;
import com.example.doctor.schedule.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentService {
    @Autowired
    private IAppointmentRepository repository;

    public AppointmentService(IAppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment addAppointment(Appointment appointment) {
        Schedule schedule = new Schedule();
        schedule.setAppointmentFlag(false);
        return repository.save(appointment);
    }
}
