package com.example.doctor.schedule.scheduleApplication;
import com.example.doctor.schedule.scheduleService.scheduleService;
import com.example.doctor.schedule.Schedule;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.doctor.doctor.Doctor;

import java.util.List;

@SpringBootApplication
public class scheduleApplication {
    @Autowired
    private scheduleService scheduleService;

}