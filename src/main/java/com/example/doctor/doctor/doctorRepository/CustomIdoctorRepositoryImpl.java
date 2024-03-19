package com.example.doctor.doctor.doctorRepository;

import com.example.doctor.doctor.Doctor;
import com.example.doctor.doctor.doctorRepository.CustomIdoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomIdoctorRepositoryImpl implements CustomIdoctorRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomIdoctorRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Doctor> searchDoctors(String data) {
        var criteria = TextCriteria.forDefaultLanguage().matchingPhrase(data).caseSensitive(false);
        var query = TextQuery.queryText(criteria).sortByScore().includeScore();
        return mongoTemplate.find(query, Doctor.class);
    }
}
