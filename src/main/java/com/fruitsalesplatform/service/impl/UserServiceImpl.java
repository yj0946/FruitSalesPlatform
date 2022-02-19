package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.annotation.LogAnno;
import com.fruitsalesplatform.dao.UserNewDao;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Service           //为了包扫描的时候这个Service被扫描到
public class UserServiceImpl implements UserService {
    @Autowired
    UserNewDao userNewDao;

    @LogAnno(operateType = "(用户信息模块)获取一条记录")
    public User getOneRecord(Serializable id) {
       return userNewDao.getOneRecord(id);
    }

    @LogAnno(operateType = "(用户信息模块)获取多条记录")
    public List<User> getMoreRecord(Map map) {
       return userNewDao.getMoreRecord(map);
    }

    @LogAnno(operateType = "(用户信息模块)插入一条记录")
    public void insertRecord(User user) {
        userNewDao.insertRecord(user);
    }

    @LogAnno(operateType = "(用户信息模块)更新一条记录")
    public void updateRecord(User user) {
        userNewDao.updateRecord(user);
    }

    @LogAnno(operateType = "(用户信息模块)删除一条记录")
    public void deleteRecord(Serializable id) {
        userNewDao.deleteRecord(id);
    }

    @LogAnno(operateType = "(用户信息模块)删除多条记录")
    public void deleteRecord(Serializable[] ids) {
        userNewDao.deleteRecord(ids);
    }
}
