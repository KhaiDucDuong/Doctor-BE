package com.example.doctor.schedule.scheduleService;

import com.example.doctor.account.Account;
import com.example.doctor.schedule.Schedule;
import com.example.doctor.schedule.scheduleRepository.IscheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class scheduleService {
    @Autowired
    private IscheduleRepository repository;

    public scheduleService(IscheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule addSchedule(Schedule schedule) {
        return repository.save(schedule);
    }

    public String findDayofWeek(String dateOfweek) {
        Schedule schedule = repository.findSchedulesByDateOfweek(dateOfweek);
        if (schedule != null) {
            return schedule.getDateOfweek();
        } else {
            return null;
        }
    }

    public String findStartTime(String dateOfweek) {
        Schedule schedule = repository.findSchedulesByDateOfweek(dateOfweek);
        if (schedule != null) {
            return schedule.getTime();
        } else {
            return null;
        }
    }
}
