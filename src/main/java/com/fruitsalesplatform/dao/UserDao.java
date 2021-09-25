package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int insertUser(User user);

    List<User> findUserByName(Map<String, String> mapUserName);
}
