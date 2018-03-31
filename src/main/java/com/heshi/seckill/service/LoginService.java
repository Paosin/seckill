package com.heshi.seckill.service;

import com.heshi.seckill.dao.UserMapper;
import com.heshi.seckill.entity.User;
import com.heshi.seckill.utils.HashUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 登录Service
 *
 * @author Paosin
 * @version 1.0
 * @className LoginService
 * @date 2018/3/17 21:51
 */
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public boolean register(User user) {
        return this.userMapper.register(user) > 0;
    }

    public User login(String username, String password) {
        return this.userMapper.login(username, HashUtils.getMD5(password));
    }
}
