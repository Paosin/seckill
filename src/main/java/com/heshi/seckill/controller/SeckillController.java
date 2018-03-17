package com.heshi.seckill.controller;

import com.heshi.seckill.common.Message;
import com.heshi.seckill.entity.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paosin
 * @version 1.0
 * @className SeckillController
 * @date 2018/3/17 21:51
 */
@RestController
@RequestMapping("seckill")
public class SeckillController {
    /**
     * 秒杀操作
     * <p>
     * 将用户id写入Redis
     *
     * @return
     */
    @PostMapping("v1/product/{pid}")
    public Message seckill1(User user) {
        return Message.getSuccess();
    }

    /**
     * 直接通过MySQL进行秒杀操作
     *
     * @param user
     * @return
     */
    @PostMapping("v2/product/{pid}")
    public Message seckill2(User user) {
        return Message.getSuccess();
    }
}
