package com.priyanshu.q_02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_02.model.Job;
import com.priyanshu.q_02.service.JobService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<Job> postJob(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.addJob(job), HttpStatus.CREATED);
    }

    @GetMapping("/job")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> list = jobService.getAllJob();

        if (list.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<Job>(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("job/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable int jobId) {
        Optional<Job> job = jobService.getJobById(jobId);

        if (job.isPresent()) {
            return new ResponseEntity<>(job.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}