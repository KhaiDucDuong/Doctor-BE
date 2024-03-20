package com.example.doctor.schedule.scheduleController;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorService.DoctorService;
import com.example.doctor.schedule.scheduleApplication.scheduleApplication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*")

public class scheduleController {
    @Autowired
    private scheduleApplication scheduleApplication;
    @Autowired
    private HttpServletRequest request;
    public scheduleController(scheduleApplication scheduleApplication) {
        this.scheduleApplication = scheduleApplication;
    }

}
