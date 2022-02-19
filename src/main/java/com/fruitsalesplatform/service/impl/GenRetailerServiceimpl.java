package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.annotation.LogAnno;
import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.example.RetailerExample;
import com.fruitsalesplatform.mapper.GenRetailerMapper;
import com.fruitsalesplatform.mapper.LogtableMapper;
import com.fruitsalesplatform.service.GenRetailerService;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service         //为了包扫描的时候这个Service被扫描到
public class GenRetailerServiceimpl implements GenRetailerService {
    @Autowired
    private GenRetailerMapper mGenRetailerMapper;

    @LogAnno(operateType = "(零售商模块逆向)统计多条记录")
    @Cacheable(value="(GenRetailer)countByExample")
    @Override
    public long countByExample(RetailerExample example) {
        return mGenRetailerMapper.countByExample(example);
    }

    @LogAnno(operateType = "(零售商模块逆向)删除记录")
    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int deleteByExample(RetailerExample example) {
        return mGenRetailerMapper.deleteByExample(example);
    }

    @LogAnno(operateType = "(零售商模块逆向)删除记录通过主键")
    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int deleteByPrimaryKey(String retailerId) {
        return mGenRetailerMapper.deleteByPrimaryKey(retailerId);
    }

    @LogAnno(operateType = "(零售商模块逆向)插入记录")
    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int insert(Retailer record) {
        return mGenRetailerMapper.insert(record);
    }

    @LogAnno(operateType = "(零售商模块逆向)插入活动记录")
    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int insertSelective(Retailer record) {
        return mGenRetailerMapper.insertSelective(record);
    }

    @LogAnno(operateType = "(零售商模块逆向)选择记录")
    @Cacheable(value="(GenRetailer)selectByExample")
    @Override
    public List<Retailer> selectByExample(RetailerExample example) {
        return mGenRetailerMapper.selectByExample(example);
    }

    @LogAnno(operateType = "(零售商模块逆向)选择记录通过主键")
    @Cacheable(value="(GenRetailer)selectByPrimaryKey")
    @Override
    public Retailer selectByPrimaryKey(String retailerid) {
        return mGenRetailerMapper.selectByPrimaryKey(retailerid);
    }

    @LogAnno(operateType = "(零售商模块逆向)更新记录通过条件判断")
    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int updateByExampleSelective(Retailer record, RetailerExample example) {
        return mGenRetailerMapper.updateByExampleSelective(record, example);
    }

    @LogAnno(operateType = "(零售商模块逆向)更新记录不通过条件判断")
    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int updateByExample(Retailer record, RetailerExample example) {
        return mGenRetailerMapper.updateByExample(record, example);
    }

    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int updateByPrimaryKeySelective(Retailer record) {
        return mGenRetailerMapper.updateByPrimaryKeySelective(record);
    }

    @CacheEvict(value= {"(GenRetailer)countByExample","(GenRetailer)selectByPrimaryKey","(GenRetailer)selectByPrimaryKey"}, allEntries=true)
    @Override
    public int updateByPrimaryKey(Retailer record) {
        return mGenRetailerMapper.updateByPrimaryKey(record);
    }
}
