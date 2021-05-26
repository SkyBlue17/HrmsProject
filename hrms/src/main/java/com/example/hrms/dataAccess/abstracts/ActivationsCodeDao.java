package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationsCodeDao extends JpaRepository<ActivationCode,Integer> {
}
