package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }
    @GetMapping("/getall")
    @ResponseBody
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }
}
