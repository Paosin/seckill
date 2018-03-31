package com.heshi.seckill.service;

import com.heshi.seckill.dao.SeckillMapper;
import com.heshi.seckill.entity.Seckill;
import com.heshi.seckill.utils.SnowflakeIdWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Paosin
 * @version 1.0
 * @className SeckillService
 * @date 2018/3/31 14:57
 */
@Service
public class SeckillService extends BaseService<SeckillMapper,Seckill> {

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public Seckill get(Long id) {
        return super.dao.getById(id);
    }

    @Override
    public int save(Seckill entity) {
        entity.setId(snowflakeIdWorker.nextId());
        return super.dao.save(entity);
    }

}
