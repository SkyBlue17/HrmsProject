package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTitlesService;
import com.example.hrms.dataAccess.abstracts.JobTitlesDao;
import com.example.hrms.entities.concretes.JobTitles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobTitlesManager implements JobTitlesService {

    JobTitlesDao jobTitlesDao;

    @Autowired
    public JobTitlesManager(JobTitlesDao jobTitlesDao) {
        super();
        this.jobTitlesDao = jobTitlesDao;
    }


    @Override
    public List<JobTitles> getAll() {
        return this.jobTitlesDao.findAll();
    }
}
