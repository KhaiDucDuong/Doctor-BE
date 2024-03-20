package com.example.doctor.schedule.scheduleApplication;
import com.example.doctor.account.Account;
import com.example.doctor.account.accountService.AccountService;
import com.example.doctor.schedule.scheduleService.scheduleService;
import com.example.doctor.schedule.Schedule;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.doctor.doctor.Doctor;

import java.util.List;

import static javax.management.Query.and;

@SpringBootApplication
public class scheduleApplication {
    @Autowired
    private scheduleService scheduleService;
    @Autowired
    private HttpServletRequest request;
    public Schedule createSchedule(Schedule schedule) throws Exception {
        //validate data
        if (StringUtils.isEmpty(schedule.getDateOfweek())) {
            throw new Exception("Date can not be empty");
        } else if (StringUtils.isEmpty(schedule.getTime())) {
            throw new Exception("End time can not be empty");
        } else if (scheduleService.findTime(schedule.getDateOfweek(), schedule.getTime())) {
                throw new Exception("Account name has been created");
        }
        return scheduleService.addSchedule(schedule);
    }

}