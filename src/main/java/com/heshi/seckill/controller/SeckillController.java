package com.heshi.seckill.controller;

import com.heshi.seckill.common.Message;
import com.heshi.seckill.entity.Seckill;
import com.heshi.seckill.service.SeckillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author Paosin
 * @version 1.0
 * @className SeckillController
 * @date 2018/3/31 14:32
 */
@Api("秒杀API")
@RestController
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    @GetMapping("/s")
    public Message list() {
        return Message.getSuccess(null, this.seckillService.list(new Seckill()));
    }

    @GetMapping("/{id}")
    public Message get(@PathVariable Long id){
        return Message.getSuccess(null, this.seckillService.get(id));
    }


}
