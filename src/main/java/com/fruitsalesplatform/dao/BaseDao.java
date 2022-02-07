package com.fruitsalesplatform.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T,V> {
    public T getOneRecord(Serializable id);         //查询一条数据
    public List<T> getMoreRecord(Map map);          //查询多条数据
    public void insertRecord(T entity);             //插入数据
    public String updateRecord(T entity);             //更新数据
    public String deleteRecord(Serializable id);      //删除数据
    public String deleteRecordMore(List<V> ids);   //批量删除
}
