package com.fruitsalesplatform.service.impl;

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
    public User getOneRecord(Serializable id) {
       return userNewDao.getOneRecord(id);
    }

    public List<User> getMoreRecord(Map map) {
       return userNewDao.getMoreRecord(map);
    }

    public void insertRecord(User user) {
        userNewDao.insertRecord(user);
    }

    public void updateRecord(User user) {
        userNewDao.updateRecord(user);
    }

    public void deleteRecord(Serializable id) {
        userNewDao.deleteRecord(id);
    }

    public void deleteRecord(Serializable[] ids) {
        userNewDao.deleteRecord(ids);
    }
}
