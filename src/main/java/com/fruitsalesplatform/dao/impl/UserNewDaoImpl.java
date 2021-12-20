package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.UserNewDao;
import com.fruitsalesplatform.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserNewDaoImpl extends BaseDaoImpl<User, String> implements UserNewDao {

    public UserNewDaoImpl() {
        //设置命名空间
        super.setStrNs("com.fruitsalesplatform.mapper.UserMapper");
    }
}
