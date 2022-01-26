package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.Tools.Constant;
import com.fruitsalesplatform.dao.UserNewDao;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.example.UserExample;
import junit.framework.Test;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
public class UserNewDaoImpl extends BaseDaoImpl<User, String, UserExample> implements UserNewDao {
    private String mMsg;
    private final Logger mLogUserNewDaoImpl  = Logger.getLogger(Test.class);
    public UserNewDaoImpl() {
        //设置命名空间
        super.setStrNs("com.fruitsalesplatform.mapper.UserMapper");
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public long countByExample(UserExample userExample) {
        mMsg = Constant.OK;
        int nCount = 0;
        try {
            if (userExample == null) {
                userExample = new UserExample();
            }
            UserExample.Criteria criteria = userExample.createCriteria();
        } catch (Exception e) {
            mMsg = e.getMessage();
            mLogUserNewDaoImpl.info("执行统计异常:".concat(mMsg));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 0L;
    }

     @Override
     public int deleteByExample(UserExample example) {
        return 0;
     }

    @Override
     public int deleteByPrimaryKey(Integer id){
        return 0;
     }

     @Override
     public int insert(User record) {
        return 0;
     }

     @Override
     public int insertSelective(User record) {
         return 0;
     }

     @Override
     public List<User> selectByExample(UserExample example) {
        return null;
     }

     @Override
     public User selectByPrimaryKey(Integer id) {
        return null;
     }

     @Override
     public int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example) {
         return 0;
     }

     @Override
     public int updateByExample(@Param("record") User record, @Param("example") UserExample example) {
         return 0;
     }

     @Override
     public int updateByPrimaryKeySelective(User record) {
         return 0;
     }

     @Override
     public int updateByPrimaryKey(User record) {
        return 0;
     }
}
