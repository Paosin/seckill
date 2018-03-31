package com.heshi.seckill.controller;

import com.heshi.seckill.common.Message;
import com.heshi.seckill.entity.Order;
import com.heshi.seckill.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(value = "Order", description = "The order API")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @ApiOperation("根据订单id获取订单")
    @ApiImplicitParam(name = "id", value = "订单id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Message getOrder(@PathVariable Long id) {
        return Message.getSuccess(null, this.orderService.get(id));
    }

    @ApiOperation("添加订单")
    @ApiImplicitParam(name = "order",value = "订单详细信息",required = true,dataType = "Order")
    @PostMapping("/v1")
    public Message saveOrder1(Order order) {
        if (this.orderService.save(order) > 0) {
            return Message.getSuccess();
        }
        return new Message(HttpStatus.BAD_REQUEST, "添加订单失败", null);
    }

}
