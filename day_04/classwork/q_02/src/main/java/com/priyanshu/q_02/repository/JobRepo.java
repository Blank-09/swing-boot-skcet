package com.priyanshu.q_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanshu.q_02.model.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

}