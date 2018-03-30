package com.heshi.seckill.controller;

import com.heshi.seckill.common.Message;
import com.heshi.seckill.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author Paosin
 * @version 1.0
 * @className OrderController
 * @date 2018/3/17 21:50
 */
@RestController
@RequestMapping("/order")
@Api(value = "Order",description = "The order API")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "根据订单id获取订单")
    @ApiImplicitParam(name = "id",value = "订单id",required = true,dataType = "Long")
    @GetMapping("/{id}")
    public Message getOrder(@PathVariable Long id) {
        return Message.getSuccess("登录成功");
    }

}
