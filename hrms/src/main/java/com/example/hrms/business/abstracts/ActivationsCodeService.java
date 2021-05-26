package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.ActivationCode;

public interface ActivationsCodeService {
    void generateCode(ActivationCode activationCode,Integer id);
    Result verify(String activationCode , Integer id);

}
