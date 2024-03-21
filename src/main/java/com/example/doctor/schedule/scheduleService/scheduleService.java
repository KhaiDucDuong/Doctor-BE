package com.example.doctor.schedule.scheduleService;

import com.example.doctor.schedule.Schedule;
import com.example.doctor.schedule.scheduleRepository.IscheduleRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public void setAppointmentFlagByScheduleId(ObjectId scheduleId){
        Schedule schedule = repository.findSchedulesBy_id(scheduleId);
        schedule.setAppointmentFlag(true);
        repository.save(schedule);
    }

    public List<Schedule> getScheduleByDoctorId(String id){
        ObjectId doctorId = new ObjectId(id);
        return repository.getSchedulesByDoctorId(doctorId);
    }

    public Boolean findTime(String dateOfweek, String time) {
        Schedule schedule = repository.findSchedulesByDateOfweekAndTime(dateOfweek, time);
        if (schedule != null) {
            return true;
        } else {
            return false;
        }
    }
}
