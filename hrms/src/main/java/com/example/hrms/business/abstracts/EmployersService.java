package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Employers;

import java.util.List;

public interface EmployersService {
    DataResult<Employers> add(Employers employers);
    DataResult<List<Employers>> getAll();
}
