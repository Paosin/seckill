package com.heshi.seckill.service;

import com.heshi.seckill.dao.GoodsMapper;
import com.heshi.seckill.entity.Goods;
import com.heshi.seckill.utils.SnowflakeIdWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Paosin
 * @version 1.0
 * @className GoodsService
 * @date 2018/3/30 23:44
 */
@Service
@Transactional(readOnly = true)
public class GoodsService extends BaseService<GoodsMapper, Goods> {

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public Goods get(Long id) {
        return super.dao.getById(id);
    }

    @Override
    @Transactional
    public int save(Goods entity) {
        entity.setId(snowflakeIdWorker.nextId());
        return super.dao.save(entity);
    }
}
