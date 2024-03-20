package com.example.doctor.appointment.appointmentController;

import com.example.doctor.appointment.Appointment;
import com.example.doctor.appointment.appointmentApplication.AppointmentApplication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentApplication appointmentApplication;
    @Autowired
    private HttpServletRequest request;
    @SneakyThrows
    @GetMapping("/booking/{data}")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment CreateAppointment(@PathVariable("data") ObjectId data, @RequestBody Appointment appointment) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            ObjectId userId = (ObjectId) session.getAttribute("userId");
            if (userId != null) {
                appointment.setPatientId(userId);
                appointment.setScheduleId(data);
                appointment.setDate(appointment.getDate());
                appointmentApplication.createAppointmentByBooking(appointment);
            }
        }
        return appointment;
    }
}
