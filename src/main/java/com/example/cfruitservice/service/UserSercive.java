package com.example.cfruitservice.service;


import com.example.cfruitservice.dao.UserDao;
import com.example.cfruitservice.entity.RequestParam;
import com.example.cfruitservice.unit.Tools;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class UserSercive {

    @Resource
    private UserDao userDao;

    public String getLoginService (RequestParam param) {
        Tools.Log("service文件接收的数据" + param.getUserName());

        String resultDao = userDao.getUserListDao(param);
        return resultDao;
    }

}
