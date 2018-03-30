package com.heshi.seckill.dao;

import java.util.List;

public interface BaseDao<E> {
    /**
     * 通过id获取实体
     * @param id
     * @return
     */
    E getById(String id);

    /**
     * 通过实体查询条件获取实体
     * @param entity
     * @return
     */
    E get(E entity);

    /**
     * 查询未被逻辑删除的所有实体
     * @param entity
     * @return
     */
    List<E> list(E entity);

    /**
     * 查询包括逻辑删除的实体
     * @param entity
     * @return
     */
    List<E> listAll(E entity);

    /**
     * 插入一条数据
     * @param entity
     * @return
     */
    int save(E entity);

    /**
     * 动态插入一条数据
     * @param entity
     * @return
     */
    int saveSelective(E entity);

    /**
     * 更新一条数据
     * @param entity
     * @return
     */
    int update(E entity);

    /**
     * 动态更新一条数据
     * @param entity
     * @return
     */
    int updateSelective(E entity);

    /**
     * 根据id逻辑删除一条数据
     * @param id
     * @return
     */
    int removeById(String id);

    /**
     * 根据条件逻辑删除一条数据
     * @param entity
     * @return
     */
    int remove(E entity);

    /**
     * 根据id物理删除一条数据
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 根据条件物理删除一条数据
     * @param entity
     * @return
     */
    int delete(E entity);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int saveList(List<E> list);

    /**
     * 批量更新
     * @param list
     * @return
     */
    int updateList(List<E> list);

    /**
     * 批量逻辑删除
     * @param list
     * @return
     */
    int removeList(List<E> list);

    /**
     * 批量物理删除
     * @param list
     * @return
     */
    int deleteList(List<E> list);
}
