package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
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
            return this.getSqlSession().selectOne(strNs + ".get", id);
        }

        @Override
        public List<T> getMoreRecord(Map map) {
            List<T> oList = this.getSqlSession().selectList(strNs + ".find", map);
            return oList;
        }

        @Override
        public void insertRecord(T entity) {
            this.getSqlSession().insert(strNs + ".insert", entity);
        }

        @Override
        public void updateRecord(T entity) {
            this.getSqlSession().update(strNs + ".update", entity);
        }

        @Override
        public void deleteRecord(Serializable id) {
            this.getSqlSession().delete(strNs + ".delete", id);
        }

        @Override
        public void deleteRecord(Serializable[] ids) {
            this.getSqlSession().delete(strNs + ".delete", ids);
        }
}
