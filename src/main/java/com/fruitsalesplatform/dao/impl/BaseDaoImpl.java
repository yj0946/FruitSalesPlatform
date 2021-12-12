package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.BaseDao;
import junit.framework.Test;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
       public static final String BASE_DAO_OK = "OK";
       private Logger mLogBaseDaoImpl  = Logger.getLogger(Test.class);
       String mReturnMsg;
       String mStrFullName;
       @Autowired
       //mybatis-spring 1.0无须此方法; mybatis-spring 1.2必须注入
       public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
           super.setSqlSessionFactory(sqlSessionFactory);
       }

        public String getStrNs() {
            return strNs;
        }

        public void setStrNs(String strNs) {
            this.strNs = strNs;
        }

        private String strNs;          //命名空间

        @Override
        public T getOneRecord(Serializable id) {
            mStrFullName = strNs.concat(".get");
            mLogBaseDaoImpl.info("Start To Execute: ".concat(mStrFullName));
            return this.getSqlSession().selectOne(mStrFullName, id);
        }

        @Override
        public List<T> getMoreRecord(Map map) {
            mStrFullName = strNs.concat(".find");
            mLogBaseDaoImpl.info("Start To Execute: ".concat(mStrFullName));
            List<T> oList = this.getSqlSession().selectList(mStrFullName, map);
            return oList;
        }

        @Override
        public void insertRecord(T entity) {
            mStrFullName = strNs.concat(".insert");
            mLogBaseDaoImpl.info("Start To Execute: ".concat(mStrFullName));
            this.getSqlSession().insert(mStrFullName, entity);
        }

        @Override
        public String updateRecord(T entity) {
            mStrFullName = strNs.concat(".update");
            mLogBaseDaoImpl.info("Start To Execute: ".concat(mStrFullName));
            mReturnMsg = BASE_DAO_OK;
            try {
                this.getSqlSession().update(mStrFullName, entity);
            } catch (Exception e) {
                mReturnMsg = e.getMessage();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            return mReturnMsg;
        }

        @Override
        public void deleteRecord(Serializable id) {
            mStrFullName = strNs.concat(".deleteById");
            mLogBaseDaoImpl.info("Start To Execute: ".concat(mStrFullName));
            this.getSqlSession().delete(mStrFullName, id);
        }

        @Override
        public void deleteRecord(Serializable[] ids) {
            mStrFullName = strNs.concat(".delete");
            mLogBaseDaoImpl.info("Start To Execute: ".concat(mStrFullName));
            this.getSqlSession().delete(mStrFullName, ids);
        }
}
