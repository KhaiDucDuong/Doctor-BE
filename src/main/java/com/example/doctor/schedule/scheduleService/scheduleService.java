package com.example.doctor.schedule.scheduleService;

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


    public Schedule addSchedule(Schedule schedule){
        return repository.save(schedule);

    }
}
