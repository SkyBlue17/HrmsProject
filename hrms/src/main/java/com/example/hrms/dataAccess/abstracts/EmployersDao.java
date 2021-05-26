package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployersDao extends JpaRepository<Employers,Integer> {
        List<Employers> findAllByEmail(String email);
}
