package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.ActivationsCodeService;
import com.example.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/verify")
public class ActivationCodeController {
    private ActivationsCodeService activationsCodeService;

    @Autowired
    public ActivationCodeController(ActivationsCodeService activationsCodeService) {
        super();
        this.activationsCodeService = activationsCodeService;
    }
    public Result setVerify(@RequestParam String verificationCode,@RequestParam Integer id){
        return activationsCodeService.verify(verificationCode,id);
    }

}
