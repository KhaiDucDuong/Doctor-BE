package com.example.doctor.appointment.appointmentApplication;

import com.example.doctor.account.Account;
import com.example.doctor.appointment.Appointment;
import com.example.doctor.appointment.appointmentService.AppointmentService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppointmentApplication {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private HttpServletRequest request;
    public Appointment createAppointmentByBooking(Appointment appointment) throws Exception {
        //validate data
        if (StringUtils.isNotEmpty(appointment.getScheduleId().toString())) {
            throw new Exception("You have appointment in this time");
        }
        return appointmentService.addAppointment(appointment);
    }
}
