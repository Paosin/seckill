package com.heshi.seckill.dao;

import com.heshi.seckill.entity.Goods;

import org.springframework.stereotype.Component;

/**
 * @author Paosin
 * @version 1.0
 * @className GoodsMapper
 * @date 2018/3/30 23:45
 */
@Component
public interface GoodsMapper extends BaseDao<Goods>{
    Goods getById(Long id);
}
