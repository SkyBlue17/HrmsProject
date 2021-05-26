package com.example.hrms.core.utilities.results;

import com.example.hrms.services.FakeMernisService;

public class IdentityValidation {
    public static boolean isRealPerson(String tcno){
        FakeMernisService fakeMernisService = new FakeMernisService();
        return fakeMernisService.validate(tcno);

    }
}
