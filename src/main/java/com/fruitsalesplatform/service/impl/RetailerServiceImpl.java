package com.fruitsalesplatform.service.impl;

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

      @Cacheable(value="getOneRecord")
      public Retailer getOneRecord(Serializable id) {
          return retailerDao.getOneRecord(id);
      }

      @Cacheable(value="getMoreRecord")
      public List<Retailer> getMoreRecord(Map map) {
          return retailerDao.getMoreRecord(map);
      }

      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public void insertRecord(Retailer retailer) {
          retailerDao.insertRecord(retailer);
      }

      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public String updateRecord(Retailer retailer) {
          return retailerDao.updateRecord(retailer);
      }

      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public void deleteRecord(Serializable id) {
          retailerDao.deleteRecord(id);
      }

      @CacheEvict(value= {"getOneRecord","getMoreRecord","count"}, allEntries=true)
      public void deleteRecord(Serializable[] ids) {
          retailerDao.deleteRecord(ids);
      }

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
