package com.heshi.seckill.service;

import com.heshi.seckill.dao.BaseDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Paosin
 * @version 1.0
 * @className BaseService
 * @date 2018/3/29 20:43
 */
@Transactional(readOnly = true)
public class BaseService<D extends BaseDao<E>, E> {

    @Autowired
    protected D dao;

    public E get(String id) {
        return this.dao.getById(id);
    }

    public E get(E entity) {
        return this.dao.get(entity);
    }

    public List<E> list(E entity) {
        return this.dao.list(entity);
    }

    public List<E> listAll(E entity) {
        return this.dao.listAll(entity);
    }

    @Transactional
    public int save(E entity) {
        return this.dao.save(entity);
    }

    @Transactional
    public int update(E entity) {
        return this.dao.update(entity);
    }

    @Transactional
    public int remove(String id) {
        return this.dao.removeById(id);
    }
}
