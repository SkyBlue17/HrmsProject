package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ActivationsCodeService;
import com.example.hrms.business.abstracts.JobSeekersService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.IdentityValidation;
import com.example.hrms.core.utilities.results.SuccesDataResult;
import com.example.hrms.dataAccess.abstracts.JobSeekersDao;
import com.example.hrms.entities.concretes.ActivationCode;
import com.example.hrms.entities.concretes.JobSeekers;
import com.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JobseekersManager implements JobSeekersService {

    @Autowired
    private JobSeekersDao jobSeekersDao;
    private ActivationsCodeService activationsCodeService;
    private UserService userService;



    public JobseekersManager(JobSeekersDao jobSeekersDao, ActivationsCodeService activationsCodeService, UserService userService) {
        super();
        this.jobSeekersDao = jobSeekersDao;
        this.activationsCodeService = activationsCodeService;
        this.userService = userService;
    }


    @Override
    public DataResult<JobSeekers> add(JobSeekers jobSeekers) {
        if(!firstNameChecker(jobSeekers)){
            return new ErrorDataResult<JobSeekers>(null,"İsminizi yazmanız gerekmektedir.");
        }
        else if (!lastNameChecker(jobSeekers)){
            return new ErrorDataResult<JobSeekers>(null,"Soyadınızı yazmanız gerekmektedir.");
        }
        else if (!IdentityValidation.isRealPerson(jobSeekers.getNationalityNumber())){
            return new ErrorDataResult<JobSeekers>(null,"Kimlik doğrulanamadı");
        }
        else if (!jobSeekers.getNationalityNumber().isBlank()){
            return new ErrorDataResult<JobSeekers>(null,"Tc kimlik bilgisi girilmelidir.");
        }
        else if (!birthDateChecker(jobSeekers)){
            return new ErrorDataResult<JobSeekers>(null,"Doğum tarihi bilgisi yazınız.");
        }
        else if (!emailNullChecker(jobSeekers)){
            return new ErrorDataResult<JobSeekers>(null,"Email bilgisi giriniz.");
        }
        else if(!isRealEmail(jobSeekers)){
            return new ErrorDataResult<JobSeekers>(null,"E mail adresi hatalı.");
        }
        else if (!passwordNullChecker(jobSeekers)){
            return new ErrorDataResult<JobSeekers>(null,"Şifre bilgisi giriniz.");
        }
        else if (jobSeekersDao.findAllByEmail(jobSeekers.getEmail()).stream().count() != 0){
            return new ErrorDataResult<JobSeekers>(null,"Email sistemde zaten kayıtlı.");
        }
        else if (jobSeekersDao.findAllByNationalityNumber(jobSeekers.getNationalityNumber()).stream().count() != 0){
            return new ErrorDataResult<JobSeekers>(null,"Tc kimlik numarası sistemde mevcut");
        }
        User savedUser = this.userService.add(jobSeekers);
        this.activationsCodeService.generateCode(new ActivationCode(), savedUser.getId());
        return new SuccesDataResult<JobSeekers>(this.jobSeekersDao.save(jobSeekers),"İş arayan hesabı eklendi ,  Doğrulama kodu gönderildi:"+jobSeekers.getId());


    }


    @Override
    public DataResult<List<JobSeekers>> getAll() {
        return new SuccesDataResult<List<JobSeekers>>(this.jobSeekersDao.findAll(),"İş arayanlar başarıyla listelendi");



    }

    private boolean firstNameChecker(JobSeekers jobSeekers){
        if (jobSeekers.getFirstName().isBlank() || jobSeekers.getFirstName().equals(null)){
            return false;
        }
        return true;
    }
    private boolean lastNameChecker(JobSeekers jobSeekers){
        if (jobSeekers.getLastName().isBlank() || jobSeekers.getLastName().equals(null)){
            return false;
        }
        return true;
    }
    private boolean birthDateChecker(JobSeekers jobSeekers) {
        if (jobSeekers.getBirthdayDate().equals(null)){
            return false;
        }
        return true;
    }
    private boolean emailNullChecker(JobSeekers jobSeekers){
        if (jobSeekers.getEmail().isBlank() || jobSeekers.getEmail().equals(null)){
            return false;
        }
        return true;
    }
    private boolean passwordNullChecker(JobSeekers jobSeekers){
        if (jobSeekers.getPassword().isBlank() || jobSeekers.getPassword().equals(null)){
            return false;
        }
        return true;
    }
    private boolean isRealEmail(JobSeekers jobSeekers){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jobSeekers.getEmail());
        if(!matcher.matches()) {
            return false;
        }
        return true;
    }








}
