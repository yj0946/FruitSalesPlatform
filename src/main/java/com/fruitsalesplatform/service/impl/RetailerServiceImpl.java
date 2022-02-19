package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.annotation.LogAnno;
import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service         //为了包扫描的时候这个Service被扫描到
public class RetailerServiceImpl implements RetailerService {
      @Autowired
      RetailerDao retailerDao;

      @LogAnno(operateType = "(零售商模块)获取一条记录")
      @Cacheable(value="getOneRecord")
      public Retailer getOneRecord(Serializable id) {
          return retailerDao.getOneRecord(id);
      }

      @LogAnno(operateType = "(零售商模块)获取多条记录")
      @Cacheable(value="getMoreRecord")
      public List<Retailer> getMoreRecord(Map map) {
          return retailerDao.getMoreRecord(map);
      }

      @LogAnno(operateType = "(零售商模块)插入一条记录")
      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public void insertRecord(Retailer retailer) {
          retailerDao.insertRecord(retailer);
      }

      @LogAnno(operateType = "(零售商模块)更新一条记录")
      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public String updateRecord(Retailer retailer) {
          return retailerDao.updateRecord(retailer);
      }

      @LogAnno(operateType = "(零售商模块)删除一条记录")
      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public String deleteRecord(Serializable id) {
         return retailerDao.deleteRecord(id);
      }

      @LogAnno(operateType = "(零售商模块)删除多条记录")
      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public String deleteRecordMore(List<String> ids) {
         return retailerDao.deleteRecordMore(ids);
      }

      @LogAnno(operateType = "(零售商模块)统计数量")
      @Cacheable(value="count")
      public int count() {
           return retailerDao.count();
      }

      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public String insertMoreRecord(Retailer[] entityArr)
      {
          return retailerDao.insertMoreRecord(entityArr);
      }

      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public String updateMoreRetailer(Retailer[] retailers) {
        return retailerDao.updateMoreRetailer(retailers);
      }
}
