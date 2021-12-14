package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;
import junit.framework.Test;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Repository           //为了在包扫描的时候这个Dao被扫描到
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {
    public static final String OK = "OK";
    public static final int RETAILER_PATH_INSERT = 0x1;
    public static final int RETAILER_PATH_UPDATE = 0x2;
    public static final int RETAILER_PATH_DELETE = 0x3;
    private final Logger mLogRetailerDaoImpl  = Logger.getLogger(Test.class);
    private String mMsg = OK;

    public RetailerDaoImpl() {
        //设置命名空间
        super.setStrNs("com.fruitsalesplatform.mapper.RetailerMapper");
    }

    //实现接口自己的方法
    public int count() {
        mLogRetailerDaoImpl.info("开始执行[RetailerDaoImpl]：count:");
        return this.getSqlSession().selectOne(this.getStrNs() + ".count");

    }

    private void pathProcess(int nSelectValue, Retailer[] retailers) {
        Retailer retailer;
        try {
            for (Retailer value : retailers) {
                retailer = value;
                switch (nSelectValue) {
                    case RETAILER_PATH_INSERT:
                        this.getSqlSession().insert(this.getStrNs() + ".insert", retailer);
                        break;
                    case RETAILER_PATH_UPDATE:
                        this.getSqlSession().update(this.getStrNs() + ".update", retailer);
                        break;
                    default:
                        break;
                }

            }
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行插入异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Transactional(rollbackFor=Exception.class)
    public String insertMoreRecord(Retailer[] retailers){
        mLogRetailerDaoImpl.info("开始执行:insertMoreRecord:");
        pathProcess(RETAILER_PATH_INSERT, retailers);
        mLogRetailerDaoImpl.info("执行结束:insertMoreRecord:");
        return mMsg;
    }

    @Transactional(rollbackFor=Exception.class)
    public String updateMoreRetailer(Retailer[] retailers) {
        mLogRetailerDaoImpl.info("开始执行:updateMoreRetailer:");
        pathProcess(RETAILER_PATH_UPDATE, retailers);
        mLogRetailerDaoImpl.info("执行结束:updateMoreRetailer:");
        return mMsg;
    }
}
