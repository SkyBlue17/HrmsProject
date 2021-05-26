package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTitlesService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.SuccesDataResult;
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
    public DataResult<JobTitles> add(JobTitles title) {
        if (jobTitlesDao.findAllByTitle(title.getTitle()).stream().count() !=0 ){
            return new ErrorDataResult<JobTitles>(null,"Bu iş pozisyonu sistemde kayıtlıdır.");
        }
        return new SuccesDataResult<JobTitles>(this.jobTitlesDao.save(title),"İş pozisyonunuz sisteme eklendi.");
    }

    @Override
    public DataResult<List<JobTitles>> getAll() {
        return new SuccesDataResult<List<JobTitles>>(jobTitlesDao.findAll(),"Başarılı şekilde listelendi.");
    }

    @Override
    public DataResult<List<JobTitles>> findById(int id) {
        return new SuccesDataResult<List<JobTitles>>(this.jobTitlesDao.findById(id),"Başarılı şekilde listelendi");
    }

    @Override
    public DataResult<List<JobTitles>> findByTitles(String title) {
        return new SuccesDataResult<List<JobTitles>>(this.jobTitlesDao.findJobTitles(title),"Başarılı şekilde listelendi.");
    }


}
