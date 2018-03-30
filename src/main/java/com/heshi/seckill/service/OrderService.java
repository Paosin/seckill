package com.heshi.seckill.service;

import com.heshi.seckill.dao.OrderMapper;
import com.heshi.seckill.entity.Order;

import org.springframework.stereotype.Service;

/**
 * @author Paosin
 * @version 1.0
 * @className OrderService
 * @date 2018/3/17 21:51
 */
@Service
public class OrderService extends BaseService<OrderMapper, Order> {
    public Order get(Long id) {
        return dao.getById(id);
    }
}
