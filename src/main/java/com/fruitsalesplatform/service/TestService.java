package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.User;

import java.util.List;
import java.util.Map;

public interface TestService {
    int insertUser(User user);

    List<User> findUserByName(Map<String, String> mapUserName);
}
