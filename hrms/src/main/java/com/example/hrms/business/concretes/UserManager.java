package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccesDataResult;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManager implements UserService {
    @Autowired
    private UserDao userDao;

    public UserManager() {

    }


    @Override
    public DataResult<List<User>> getAll() {
        return new SuccesDataResult<List<User>>(userDao.findAll(),"Başarılı şekilde kullanıcılar listelendi.");
    }

    @Override
    public User add(User user) {
        return userDao.save(user);
    }
}
