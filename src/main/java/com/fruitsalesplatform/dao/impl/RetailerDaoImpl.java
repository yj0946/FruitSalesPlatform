package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository           //为了在包扫描的时候这个Dao被扫描到
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {

    public RetailerDaoImpl() {
        //设置命名空间
        super.setStrNs("com.fruitsalesplatform.mapper.RetailerMapper");
    }

    //实现接口自己的方法
    public int count(Map map) {
        return this.getSqlSession().selectOne(this.getStrNs() + ".count", map);
    }
}
