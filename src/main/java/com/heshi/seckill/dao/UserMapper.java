package com.heshi.seckill.dao;

import com.heshi.seckill.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseDao<User>{
    User login(@Param("username") String username,@Param("password") String password);

    int register(User user);
}
