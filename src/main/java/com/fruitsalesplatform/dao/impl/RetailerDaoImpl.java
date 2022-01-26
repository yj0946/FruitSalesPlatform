package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.Tools.Constant;
import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.dao.RetailerMapper;
import com.fruitsalesplatform.entity.ErrorMsg;
import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.example.RetailerExample;
import com.fruitsalesplatform.example.RetailerExample;
import junit.framework.Test;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository           //为了在包扫描的时候这个Dao被扫描到
public class RetailerDaoImpl extends BaseDaoImpl<Retailer, String, RetailerExample> implements RetailerDao {
    public static final int RETAILER_PATH_INSERT = 0x1;
    public static final int RETAILER_PATH_UPDATE = 0x2;
    public static final int RETAILER_PATH_DELETE = 0x3;
    public static final int RETAILER_PATH_INSERT_PREFIX = 0x4;
    public static final int RETAILER_PATH_UPDATE_PREFIX = 0x5;
    public static final int RETAILER_PATH_DELETE_PREFIX = 0x6;

    public static final int RETAILER_MAPPER_COUNT_BY_EXAMPLE = 0x7;
    public static final int RETAILER_MAPPER_DELETE_BY_EXAMPLE = 0x8;
    private final Logger mLogRetailerDaoImpl  = Logger.getLogger(Test.class);
    private String mMsg;

    @Resource
    private RetailerMapper mRetailerMapper;

    public RetailerDaoImpl() {
        //设置命名空间
        super.setStrNs("com.fruitsalesplatform.mapper.RetailerMapper");
    }

    //实现接口自己的方法
    public int count() {
        mLogRetailerDaoImpl.info("开始执行[RetailerDaoImpl]：count:");
        return this.getSqlSession().selectOne(this.getStrNs() + ".count");

    }

    private void pathProcessByPrefix(int nSelectValue, Retailer[] retailers) {
        List<Retailer> lstRetailer = new ArrayList<>(retailers.length);
        lstRetailer.addAll(Arrays.asList(retailers));
        mMsg = Constant.OK;
        try {
             switch(nSelectValue) {
                 case RETAILER_PATH_INSERT_PREFIX:
                     this.getSqlSession().insert(this.getStrNs() + ".insertPathByPrefix", lstRetailer);
                     break;
                 case RETAILER_PATH_UPDATE_PREFIX:
                     this.getSqlSession().update(this.getStrNs() + ".updatePathByPrefix", lstRetailer);
                     break;
                 case RETAILER_PATH_DELETE_PREFIX:
                     this.getSqlSession().delete(this.getStrNs() + ".deletePathByPrefix", lstRetailer);
                     break;
                 default:
                     break;
             }
        } catch (Exception e) {
            getExceptionMsg(nSelectValue, e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    private void getExceptionMsg(int nSelectValue, Exception e) {
        mMsg = e.getMessage();
        mLogRetailerDaoImpl.info("执行插入异常:".concat(mMsg));
        switch (nSelectValue) {
            case RETAILER_PATH_INSERT:
            case RETAILER_PATH_INSERT_PREFIX:
                mMsg = ErrorMsg.PATH_INSERT_MSG;
                break;
            case RETAILER_PATH_UPDATE:
            case RETAILER_PATH_UPDATE_PREFIX:
                mMsg = ErrorMsg.PATH_UPDATE_MSG;
                break;
            case RETAILER_PATH_DELETE:
            case RETAILER_PATH_DELETE_PREFIX:
                 mMsg = ErrorMsg.PATH_DELETE_MSG;
                break;
            default:
                break;
        }
    }

    private void pathProcess(int nSelectValue, Retailer[] retailers) {
        Retailer retailer;
        mMsg = Constant.OK;
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
                    case RETAILER_PATH_DELETE:
                        this.getSqlSession().delete(this.getStrNs() + ".delete", retailer);
                        break;
                    default:
                        break;
                }

            }
        } catch (Exception e) {
            getExceptionMsg(nSelectValue, e);
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
        pathProcessByPrefix(RETAILER_PATH_UPDATE_PREFIX, retailers);
        mLogRetailerDaoImpl.info("执行结束:updateMoreRetailer:");
        return mMsg;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public long countByExampleName(RetailerExample retailerExample) {
        mMsg = Constant.OK;
        long nCount = 0;
        try {
            if (retailerExample == null) {
                retailerExample = new RetailerExample();
            }
            RetailerExample.Criteria criteriaCount = retailerExample.createCriteria();
            criteriaCount.andNameEqualTo("jack");
            nCount = mRetailerMapper.countByExample(retailerExample);
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行统计异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return nCount;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public long countByExample(RetailerExample retailerExample) {
        mMsg = Constant.OK;
        long nCount = 0;
        try {
            if (retailerExample == null) {
                retailerExample = new RetailerExample();
            }
            RetailerExample.Criteria criteriaCount = retailerExample.createCriteria();
            nCount = mRetailerMapper.countByExample(retailerExample);
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行统计异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return nCount;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int deleteByExample(RetailerExample retailerExample) {
        mMsg = Constant.OK;
        int nDelete = 0;
        try {
            if (retailerExample == null) {
                retailerExample = new RetailerExample();
            }
            RetailerExample.Criteria criteriaDelete = retailerExample.createCriteria();
            criteriaDelete.andNameEqualTo("jack");
            nDelete = mRetailerMapper.deleteByExample(retailerExample);
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行删除异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return nDelete;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int deleteByPrimaryKey(Integer id){
        mMsg = Constant.OK;
        int nDelete = 0;
        try {
            nDelete = mRetailerMapper.deleteByPrimaryKey(String.valueOf(id));
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行删除按主键id异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return nDelete;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int insert(Retailer record) {
        mMsg = Constant.OK;
        int nInsert = 0;
        try {
            nInsert = mRetailerMapper.insert(record);
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行插入统计异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return nInsert;
    }

    @Override
    public int insertSelective(Retailer record) {
        mMsg = Constant.OK;
        int nInsert = 0;
        try {
            nInsert = mRetailerMapper.insertSelective(record);
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行插入选择统计异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return nInsert;
    }

    @Override
    public List<Retailer> selectByExample(RetailerExample retailerExample) {
        mMsg = Constant.OK;

        List<Retailer> lstRetailer = null;
        try {
            if (retailerExample == null) {
                retailerExample = new RetailerExample();
            }
            RetailerExample.Criteria criteria = retailerExample.createCriteria();
            criteria.andNameEqualTo("jack");
            criteria.andNameIsNotNull();
            lstRetailer = mRetailerMapper.selectByExample(retailerExample);
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行插入选择统计异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return lstRetailer;
    }

    @Override
    public Retailer selectByPrimaryKey(Integer id) {
        mMsg = Constant.OK;

        Retailer retailer = null;
        try {
            retailer = mRetailerMapper.selectByPrimaryKey(String.valueOf(id));
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogRetailerDaoImpl.info("执行插入选择统计异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return retailer;
    }

    @Override
    public int updateByExampleSelective(@Param("record") Retailer record, @Param("example") RetailerExample example) {
        return 0;
    }

    @Override
    public int updateByExample(@Param("record") Retailer record, @Param("example") RetailerExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Retailer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Retailer record) {
        return 0;
    }

}
