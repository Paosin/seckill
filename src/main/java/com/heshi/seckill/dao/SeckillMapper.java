package com.heshi.seckill.dao;

import com.heshi.seckill.entity.Seckill;

import org.springframework.stereotype.Component;

@Component
public interface SeckillMapper extends BaseDao<Seckill> {
    Seckill getById(Long id);
}
