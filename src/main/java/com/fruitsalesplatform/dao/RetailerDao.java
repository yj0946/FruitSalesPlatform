package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.Retailer;

import java.util.Map;

public interface RetailerDao extends BaseDao<Retailer>{
    //添加新的方法定义
    public int count();    //根据条件统计结果集树林
}
