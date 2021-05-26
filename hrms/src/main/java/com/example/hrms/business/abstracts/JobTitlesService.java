package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.JobTitles;

import java.util.List;
import java.util.Optional;

public interface JobTitlesService {
    DataResult<JobTitles> add(JobTitles title);

    DataResult<List<JobTitles>> getAll();
    DataResult<List<JobTitles>> findById(int id);
    DataResult<List<JobTitles>> findByTitles(String title);

}
