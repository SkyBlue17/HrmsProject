package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ActivationsCodeService;
import com.example.hrms.business.abstracts.EmployersService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.SuccesDataResult;
import com.example.hrms.dataAccess.abstracts.EmployersDao;
import com.example.hrms.entities.concretes.ActivationCode;
import com.example.hrms.entities.concretes.Employers;
import com.example.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployersManager implements EmployersService {

    private EmployersDao employersDao;
    private ActivationsCodeService activationsCodeService;
    private UserService userService;

    public EmployersManager(EmployersDao employersDao , ActivationsCodeService activationsCodeService , UserService userService){
        super();
        this.employersDao = employersDao;
        this.activationsCodeService = activationsCodeService;
        this.userService = userService;
    }

    @Override
    public DataResult<Employers> add(Employers employers) {
        if (!companyNameChecker(employers)){
            return new ErrorDataResult<Employers>(null,"Şirket adi doldurulmak zorunludur.");
        }
        else if (!websiteChecker(employers)){
            return new ErrorDataResult<Employers>(null,"Website adresi doldurmak zorunludur.");
        }
        else if (!passwordNullChecker(employers)){
            return new ErrorDataResult<Employers>(null,"Şifre bilgisi doldurmak zorunludur.");
        }
        else if (!isRealPhoneNumberChecker(employers)){
            return new ErrorDataResult<Employers>(null,"Telefon numarası geçersiz.");
        }
        else if (!isEmailAlreadyRegistered(employers)){
            return new ErrorDataResult<Employers>(null,"Email zaten kayıtlı.");
        }
        User savedUser = this.userService.add(employers);
        this.activationsCodeService.generateCode(new ActivationCode(),savedUser.getId());
        return new SuccesDataResult<Employers>(this.employersDao.save(employers),"İş veren hesabı eklendi, Doğrulama kodu gönderildi ID:"+employers.getUserId());
    }
    private boolean companyNameChecker(Employers employers){
        if (employers.getCompanyName().isBlank() || employers.getCompanyName() == null){
            return false;
        }
        return true;
    }
    private boolean websiteChecker(Employers employers){
        if (employers.getWebsite().isBlank() || employers.getWebsite() == null){
            return false;
        }
        return true;
    }
    private boolean passwordNullChecker(Employers employers){
        if (employers.getPassword().isBlank() || employers.getPassword() == null){
            return false;
        }
        return true;

    }
    private boolean isRealEmployer(Employers employers){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employers.getEmail());
        if(!matcher.matches()) {
            return false;
        }
        else if(!employers.getEmail().contains(employers.getWebsite())) {
            return false;
        }
        return true;
    }
    private boolean isEmailAlreadyRegistered(Employers employers){
        if (employersDao.findAllByEmail(employers.getEmail()).stream().count() !=0){
            return false;
        }
        return true;
    }
    private boolean isRealPhoneNumberChecker(Employers employers){
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		/*
		 * ÖRNEK TELEFON NUMARALARI
		 * String[] validPhoneNumbers
      = {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
      "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};
		 */
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(employers.getPhoneNumber());
        if(!matcher.matches()) {
            return false;
    }
        return true;
    }

    @Override
    public DataResult<List<Employers>> getAll() {
        return new SuccesDataResult<List<Employers>>(this.employersDao.findAll(),"İşverenler başarılı bir şekilde listelendi.");
    }
}
