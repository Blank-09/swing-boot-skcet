package com.priyanshu.q_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.priyanshu.q_01.model.Course;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    @Query("SELECT o FROM Course o WHERE o.institute.id = :instituteId")
    List<Course> findByInstituteId(int instituteId);

}
