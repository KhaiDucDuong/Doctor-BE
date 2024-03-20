package com.example.doctor.schedule.scheduleRepository;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.schedule.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IscheduleRepository extends MongoRepository<Schedule,String> {
    Schedule findSchedulesByDateOfweek(String dateOfweek);
}