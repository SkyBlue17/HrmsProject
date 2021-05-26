package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobTitles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobTitlesDao extends JpaRepository<JobTitles,Integer> {
    @Query("select u from JobTitles u where lower(u.title) like lower(concat('%', :title,'%'))")
    List<JobTitles> findJobTitles(@Param("title") String title);
    List<JobTitles> findAllByTitle(String title);
    List<JobTitles> findById(@Param("") int id);
}
