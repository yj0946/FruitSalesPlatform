package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.Retailer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface RetailerService {
    public Retailer getOneRecord(Serializable id);         //查询一条数据
    public List<Retailer> getMoreRecord(Map map);          //查询多条数据
    public void insertRecord(Retailer entity);             //插入数据
    public void updateRecord(Retailer entity);             //更新数据
    public void deleteRecord(Serializable id);      //删除数据
    public void deleteRecord(Serializable[] ids);   //批量删除
    public int count();
}
