package com.priyanshu.q_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Course;
import com.priyanshu.q_01.model.Institute;
import com.priyanshu.q_01.repository.CourseRepo;
import com.priyanshu.q_01.repository.InstituteRepo;

@Service
public class InstituteService {

    @Autowired
    private InstituteRepo instituteRepo;

    @Autowired
    private CourseRepo courseRepo;

    public ResponseEntity<Institute> add(Institute institute) {
        return new ResponseEntity<>(instituteRepo.save(institute), HttpStatus.CREATED);
    }

    public ResponseEntity<Course> addCourseInInstitute(int instituteId, Course course) {
        Optional<Institute> existing = instituteRepo.findById(instituteId);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Institute institute = existing.get();
        course.setInstitute(institute);

        return new ResponseEntity<>(courseRepo.save(course), HttpStatus.CREATED);
    }

    public List<Institute> getAllInstitutes() {
        return instituteRepo.findAll();
    }

    public ResponseEntity<Institute> updateInstitute(int instituteId, Institute institute) {
        Optional<Institute> existing = instituteRepo.findById(instituteId);

        if (!existing.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Institute updatedInstitute = existing.get();
        updatedInstitute.setContactNumber(institute.getContactNumber());
        updatedInstitute.setEmail(institute.getEmail());
        updatedInstitute.setInstituteAddress(institute.getInstituteAddress());
        updatedInstitute.setInstituteDescription(institute.getInstituteDescription());
        updatedInstitute.setInstituteName(institute.getInstituteName());
        instituteRepo.save(updatedInstitute);

        return ResponseEntity.ok(updatedInstitute);
    }

}
