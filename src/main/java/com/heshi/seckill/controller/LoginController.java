package com.heshi.seckill.controller;

import com.heshi.seckill.common.Message;
import com.heshi.seckill.entity.User;
import com.heshi.seckill.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Paosin
 * @version 1.0
 * @className LoginController
 * @date 2018/3/17 21:50
 */
@Api(value = "LoginController", description = "登录相关api")
@RestController
@RequestMapping("/u")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "注册", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 405, message = "注册失败")
    })
    @ApiImplicitParam(name = "user", value = "用户信息", dataType = "User")
    @PostMapping
    public Message register(User user) {
        if (loginService.register(user)) {
            return Message.getSuccess();
        }
        return new Message(HttpStatus.BAD_REQUEST, "注册失败", null);
    }

    @ApiOperation(value = "登录", httpMethod = "POST", notes = "ajax登录,并将用户信息存入session中")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 405, message = "用户名或密码错误")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("/login")
    public Message login(String username, String password, HttpSession session) {
        User user = this.loginService.login(username, password);
        if (user == null) {
            return new Message(HttpStatus.BAD_REQUEST, "用户名或密码错误", null);
        }
        session.setAttribute("user", user);
        return Message.getSuccess();
    }
}
