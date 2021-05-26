package com.example.hrms.core.utilities.results;

import com.example.hrms.entities.concretes.JobTitles;

import java.util.Optional;

public class SuccesDataResult<T> extends DataResult<T> {

    public SuccesDataResult(T data ,String message){
        super(data,true,message);
    }
    public SuccesDataResult(T data){
        super(data,true);
    }
    public SuccesDataResult(String message){
        super(null,true,message);
    }
    public SuccesDataResult(Optional<JobTitles> byId, String başarılı_şekilde_listelendi){
        super(null,true);
    }
}
