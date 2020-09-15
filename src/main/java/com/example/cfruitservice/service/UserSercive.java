package com.example.cfruitservice.service;


import com.example.cfruitservice.dao.UserDao;
import com.example.cfruitservice.entity.UserInfo;
import com.example.cfruitservice.unit.Tools;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class UserSercive {

    @Resource
    private UserDao userDao;

    public String getLoginService (UserInfo userInfo) {

        String resultDao = userDao.getUserListDao(userInfo);
        return resultDao;
    }

}
