package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobTitlesService;
import com.example.hrms.entities.concretes.JobTitles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {

    private JobTitlesService jobTitlesService;


    public JobTitlesController(JobTitlesService jobTitlesService) {
        super();
        this.jobTitlesService = jobTitlesService;
    }
    @GetMapping("/getall")
    public List<JobTitles> getAll(){return this.jobTitlesService.getAll();}


}
