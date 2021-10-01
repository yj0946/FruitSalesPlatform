package com.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    public T getOneRecord(Serializable id);         //查询一条数据
    public List<T> getMoreRecord(Map map);          //查询多条数据
    public void insertRecord(T entity);             //插入数据
    public void updateRecord(T entity);             //更新数据
    public void deleteRecord(Serializable id);      //删除数据
    public void deleteRecord(Serializable[] ids);   //批量删除
}
