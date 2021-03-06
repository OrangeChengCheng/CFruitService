package com.example.cfruitservice.controllers;

import com.alibaba.fastjson.JSON;
import com.example.cfruitservice.entity.RequestParam;
import com.example.cfruitservice.entity.UserInfo;
import com.example.cfruitservice.service.UserSercive;
import com.example.cfruitservice.unit.Logger;
import com.example.cfruitservice.unit.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@RequestMapping("/cfruit")
public class UserController {

    @Autowired
    UserSercive userService;


    //获取用户列表
    @RequestMapping("/login")
    @ResponseBody
    public String getUserList(@RequestBody RequestParam param, HttpServletRequest request) throws IOException {

        //请求日志
        Logger.recordRequestOperate(param, request);

        UserInfo userInfo = JSON.parseObject(JSON.toJSONString(param.getData()),UserInfo.class);

        String result = userService.getLoginService(userInfo);
        return result;
    }



}

