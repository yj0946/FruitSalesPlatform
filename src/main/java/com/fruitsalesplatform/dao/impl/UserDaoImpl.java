package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository    //为了包扫描的时候这个Dao被扫描到
public class UserDaoImpl implements UserDao {
    @Autowired      //注入SqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession mSqlSession = null;
    private SqlSession getSqlSession() {
        if (mSqlSession == null) {
            mSqlSession = sqlSessionFactory.openSession();
        }
        return mSqlSession;
    }
    public int insertUser(User user) {
        UserDao mUserDao = getSqlSession().getMapper(UserDao.class);
        if (mUserDao != null) {
           return mUserDao.insertUser(user);
        }
        return 0;
    }

    @After
    public void destroy()throws Exception{
        mSqlSession.close();
    }
}
