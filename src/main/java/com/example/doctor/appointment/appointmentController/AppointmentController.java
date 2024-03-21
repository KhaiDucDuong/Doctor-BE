package com.example.doctor.appointment.appointmentController;

import com.example.doctor.appointment.Appointment;
import com.example.doctor.appointment.appointmentApplication.AppointmentApplication;
import com.example.doctor.appointment.appointmentService.AppointmentService;
import com.example.doctor.schedule.Schedule;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000", "http://127.0.0.1:3000"},
        allowCredentials = "true"
)
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentApplication appointmentApplication;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private HttpServletRequest request;
    @SneakyThrows
    @PostMapping("/booking/{data}")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment CreateAppointment(@PathVariable("data") ObjectId data, @RequestBody Appointment appointment) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            ObjectId userId = (ObjectId) session.getAttribute("userId");
            if (userId != null) {
                appointment.setPatientId(userId);
                appointment.setScheduleId(data);
                appointment.setDate( appointment.getDate() );
                appointment.setSymptomDescription(appointment.getSymptomDescription());
                appointment.setStatus(1);
                appointmentApplication.createAppointmentByBooking(appointment);
            }
        }
        return appointment;
    }
    @GetMapping("/appointmentOrdered")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Appointment> getAppointmentByPatientId() {
        HttpSession session = request.getSession(false);
        ObjectId userId = null;
        if (session != null) {
            userId = (ObjectId) session.getAttribute("userId");
        }
        return appointmentService.getAppointmentByPatientId(userId);
    }

}
