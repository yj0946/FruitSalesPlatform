package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;
import junit.framework.Test;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Map;
@Repository           //为了在包扫描的时候这个Dao被扫描到
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {
    public static final String OK = "OK";
    private Logger mLogRetailerDaoImpl  = Logger.getLogger("module1");


    public RetailerDaoImpl() {
        //设置命名空间
        super.setStrNs("com.fruitsalesplatform.mapper.RetailerMapper");
    }

    //实现接口自己的方法
    public int count() {
        mLogRetailerDaoImpl.info("开始执行[RetailerDaoImpl]：count:");
        return this.getSqlSession().selectOne(this.getStrNs() + ".count");

    }


    @Transactional(rollbackFor=Exception.class)
    public String insertMoreRecord(Retailer[] retailers){
        mLogRetailerDaoImpl.info("开始执行insertMoreRecord:");
        Retailer retailer;
        String strMsg = OK;
        try {
            for (int i = 0; i < retailers.length; i++) {
                retailer = retailers[i];
                this.getSqlSession().insert(this.getStrNs() + ".insert", retailer);
            }
        } catch (Exception e) {
            strMsg = e.getMessage();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        mLogRetailerDaoImpl.info("执行结束insertMoreRecord:");
        return strMsg;
    }
}
