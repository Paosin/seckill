package com.heshi.seckill.controller;

import com.heshi.seckill.common.Message;
import com.heshi.seckill.entity.User;
import com.heshi.seckill.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paosin
 * @version 1.0
 * @className LoginController
 * @date 2018/3/17 21:50
 */
@RestController
@RequestMapping("/u")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Message register(User user) {
        loginService.register(user);
        return Message.getSuccess();
    }

    @PostMapping("/login")
    public Message login(User user) {
        return loginService.login(user) ? Message.getSuccess() : Message.getFail();
    }
}
