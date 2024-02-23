package com.priyanshu.q_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanshu.q_02.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}