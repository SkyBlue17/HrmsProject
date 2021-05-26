package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ActivationsCodeService;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.GenerateRandomCode;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccesDataResult;
import com.example.hrms.dataAccess.abstracts.ActivationsCodeDao;
import com.example.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivationsCodeManager implements ActivationsCodeService {

    private ActivationsCodeDao activationsCodeDao;
    @Autowired
    public ActivationsCodeManager(ActivationsCodeDao activationsCodeDao){
        super();
        this.activationsCodeDao = activationsCodeDao;
    }

    @Override
    public void generateCode(ActivationCode activationCode, Integer id) {
        ActivationCode code = activationCode;
        activationCode.setActivationCode(null);
        activationCode.setConfirmed(false);
        if (activationCode.isConfirmed() == false){
            GenerateRandomCode generateRandomCode = new GenerateRandomCode();
            String code_create = generateRandomCode.create();
            code.setUserId(id);

            activationsCodeDao.save(activationCode);
        }
        return;
    }

    @Override
    public Result verify(String activationCode, Integer id) {
        ActivationCode ref = activationsCodeDao.getOne(id);
        if (ref.getActivationCode().equals(activationCode)) {
            ref.setConfirmed(true);
            return  new SuccesDataResult<ActivationCode>(this.activationsCodeDao.save(ref),"Başarılı");


        }
        return new ErrorDataResult<ActivationCode>(null,"Doğrulama kodu geçersizdir.");
    }
}
