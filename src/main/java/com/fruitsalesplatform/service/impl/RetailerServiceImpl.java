package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service         //为了包扫描的时候这个Service被扫描到
public class RetailerServiceImpl implements RetailerService {
      @Autowired
      RetailerDao retailerDao;
      public Retailer getOneRecord(Serializable id) {
          return retailerDao.getOneRecord(id);
      }

      public List<Retailer> getMoreRecord(Map map) {
          return retailerDao.getMoreRecord(map);
      }

      public void insertRecord(Retailer retailer) {
          retailerDao.insertRecord(retailer);
      }

      public void updateRecord(Retailer retailer) {
          retailerDao.updateRecord(retailer);
      }

      public void deleteRecord(Serializable id) {
          retailerDao.deleteRecord(id);
      }

      public void deleteRecord(Serializable[] ids) {
          retailerDao.deleteRecord(ids);
      }

      public int count(Map map) {
           return retailerDao.count(map);
      }
}
