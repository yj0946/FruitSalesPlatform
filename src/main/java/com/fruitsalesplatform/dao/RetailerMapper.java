package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.example.RetailerExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RetailerMapper {
    long countByExample(RetailerExample example);

    int deleteByExample(RetailerExample example);

    int deleteByPrimaryKey(String retailerid);

    int insert(Retailer record);

    int insertSelective(Retailer record);

    List<Retailer> selectByExample(RetailerExample example);

    Retailer selectByPrimaryKey(String retailerid);

    int updateByExampleSelective(@Param("record") Retailer record, @Param("example") RetailerExample example);

    int updateByExample(@Param("record") Retailer record, @Param("example") RetailerExample example);

    int updateByPrimaryKeySelective(Retailer record);

    int updateByPrimaryKey(Retailer record);
}
