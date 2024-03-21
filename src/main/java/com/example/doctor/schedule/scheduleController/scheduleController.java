package com.example.doctor.schedule.scheduleController;

import com.example.doctor.department.Department;
import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import com.example.doctor.patient.Patient;
import com.example.doctor.schedule.Schedule;
import com.example.doctor.schedule.scheduleApplication.scheduleApplication;
import com.example.doctor.schedule.scheduleService.scheduleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@CrossOrigin(
        origins = {"http://localhost:3000", "http://127.0.0.1:3000"},
        allowCredentials = "true",
        allowedHeaders = "*"
)
public class scheduleController {
    @Autowired
    private scheduleApplication scheduleApplication;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private scheduleService scheduleService;

    public scheduleController(scheduleApplication scheduleApplication) {
        this.scheduleApplication = scheduleApplication;
    }

    @SneakyThrows
    @PostMapping("/createSchedule")
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            ObjectId userId = (ObjectId) session.getAttribute("userId");
            if (userId != null) {
                schedule.setDoctorId(userId);
                schedule.setTime(schedule.getTime());
//                schedule.setDeparmentId(doctorService.getDepartmentByDoctorId(String.valueOf(userId)));
                schedule.setAvailableFlag(true);
                schedule.setAppointmentFlag(false);
                scheduleApplication.createSchedule(schedule);
            }
        }
        return schedule;
    }

    @GetMapping("/schedule")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Schedule> getDoctorScheduleByWeek() {
        HttpSession session = request.getSession(false);
        ObjectId userId = null;
        if (session != null) {
            userId = (ObjectId) session.getAttribute("userId");
        }
        return scheduleService.getScheduleByDoctorId(String.valueOf(userId));
    }

    @GetMapping("/listSchedule/{data}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Schedule> getDoctor(@Valid @PathVariable("data") String data) {
        return scheduleService.getScheduleByDoctorId(String.valueOf(data));
    }


}
