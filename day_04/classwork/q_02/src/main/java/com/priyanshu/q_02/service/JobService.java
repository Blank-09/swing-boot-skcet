package com.priyanshu.q_02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanshu.q_02.model.Job;
import com.priyanshu.q_02.repository.JobRepo;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<Job> getAllJob() {
        return jobRepo.findAll();
    }

    public Optional<Job> getJobById(int id) {
        return jobRepo.findById(id);
    }

    public Job addJob(Job job) {
        return jobRepo.save(job);
    }

}