package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobSeekers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekersDao extends JpaRepository<JobSeekers,Integer> {
    List<JobSeekers> findAllByEmail(String email);
    List<JobSeekers> findAllByNationalityNumber(String nationalityNumber);
}
