package com.heshi.seckill.service;

import com.heshi.seckill.dao.OrderMapper;
import com.heshi.seckill.entity.Order;
import com.heshi.seckill.utils.SnowflakeIdWorker;

import org.springframework.beans.factory.annotation.Autowired;
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
        return super.dao.getById(id);
    }

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public int save(Order entity) {
        entity.setId(snowflakeIdWorker.nextId());
        return super.dao.save(entity);
    }

}
