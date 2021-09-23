package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.dao.impl.UserDaoImpl;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserDao userDao;
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
