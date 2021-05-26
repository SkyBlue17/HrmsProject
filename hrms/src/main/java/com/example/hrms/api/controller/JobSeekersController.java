package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobSeekersService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.JobSeekers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
    private JobSeekersService jobSeekersService;

    public JobSeekersController(JobSeekersService jobSeekersService) {
        super();
        this.jobSeekersService = jobSeekersService;
    }

    public DataResult<List<JobSeekers>> getAll(){
        return this.jobSeekersService.getAll();
    }
    public DataResult<JobSeekers> add(JobSeekers jobSeekers){
        return this.jobSeekersService.add(jobSeekers);
    }
}
