package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobTitlesService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.dataAccess.abstracts.JobSeekersDao;
import com.example.hrms.dataAccess.abstracts.JobTitlesDao;
import com.example.hrms.entities.concretes.JobTitles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<JobTitles>> getAll(){
        return jobTitlesService.getAll();
    }

    @RequestMapping(value = "/findbytitle/{title}" , method = RequestMethod.GET)
    public DataResult<List<JobTitles>> findByTitle(@PathVariable("title") String title){
        return jobTitlesService.findByTitles(title);
    }
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public DataResult<List<JobTitles>> findById(@PathVariable("id")  Integer id){
        return jobTitlesService.findById(id);
    }
    @PostMapping("/add")
    public DataResult<JobTitles> add(JobTitles titles){
        return this.jobTitlesService.add(titles);
    }


}
