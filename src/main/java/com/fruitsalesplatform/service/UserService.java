package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserService {
    public User getOneRecord(Serializable id);         //只查询一个数据,常用语修改
    public List<User> getMoreRecord(Map map);          //格局条件查询多个结果
    public void insertRecord(User user);            //插入,用实体作为参数
    public void updateRecord(User user);            //修改,用实体作为参数
    public void deleteRecord(Serializable id);  //按id删除,删除一条;支持整形和字符串型类型id
    public void deleteRecord(Serializable[] ids);   //批量删除;支持整形和字符串id
}
