package com.heshi.seckill.dao;

import com.heshi.seckill.entity.Order;

import org.springframework.stereotype.Component;

/**
 * @author Paosin
 * @version 1.0
 * @className OrderMapper
 * @date 2018/3/17 21:51
 */
@Component
public interface OrderMapper extends BaseDao<Order> {
    Order getById(Long id);
}
