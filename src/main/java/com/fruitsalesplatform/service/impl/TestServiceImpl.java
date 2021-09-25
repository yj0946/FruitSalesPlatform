package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.dao.impl.UserDaoImpl;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserDao userDao;
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    public List<User> findUserByName(Map<String, String> mapUserName)
    {
        return userDao.findUserByName(mapUserName);
    }
}
