package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobTitles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitlesDao extends JpaRepository<JobTitles,Integer> {
}
