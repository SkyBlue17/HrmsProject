package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.JobSeekers;

import java.util.List;

public interface JobSeekersService {
    DataResult<JobSeekers> add(JobSeekers jobSeekers);
    DataResult<List<JobSeekers>> getAll();
}
