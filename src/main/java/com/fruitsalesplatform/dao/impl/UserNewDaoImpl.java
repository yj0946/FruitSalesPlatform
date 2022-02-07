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
public class UserNewDaoImpl extends BaseDaoImpl<User, String> implements UserNewDao {
    private String mMsg;
    private final Logger mLogUserNewDaoImpl  = Logger.getLogger(Test.class);
    public UserNewDaoImpl() {
        //设置命名空间
        super.setStrNs("com.fruitsalesplatform.mapper.UserNewDaoMapper");
    }
}
