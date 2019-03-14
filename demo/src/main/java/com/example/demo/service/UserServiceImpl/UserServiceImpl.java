package com.example.demo.service.UserServiceImpl;

import com.example.demo.config.MyMd5Util;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;


    @Override
    public User getUser(long id) {


        return userDao.getUser(id);
    }

    @Override
    public User login(String name,String pass) throws NoSuchAlgorithmException {

      List<User> list = userDao.userSalt();

        for(User sa:list){

            String salts = sa.getUser_salt();

            String hashpass = MyMd5Util.encode(MyMd5Util.encode(pass)+salts);

            User user = userDao.login(name,hashpass);

            if(user!=null){

                return user;
            }

        }
            return null;
    }
}
