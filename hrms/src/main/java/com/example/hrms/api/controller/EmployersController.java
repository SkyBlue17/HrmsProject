package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.EmployersService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    @Autowired
    private EmployersService employersService;


    public EmployersController(EmployersService employersService) {
        super();
        this.employersService = employersService;
    }
    @GetMapping("/getall")
    public DataResult<List<Employers>> getAll(){
        return this.employersService.getAll();
    }

    public DataResult<Employers> add(Employers employers){
        return this.employersService.add(employers);
    }

}
