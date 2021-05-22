package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.JobTitles;

import java.util.List;

public interface JobTitlesService {
    List<JobTitles> getAll();
}
