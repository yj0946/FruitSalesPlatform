package com.fruitsalesplatform.mapper;

import com.fruitsalesplatform.entity.Logtable;
import com.fruitsalesplatform.example.LogtableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogtableMapper {
    long countByExample(LogtableExample example);

    int deleteByExample(LogtableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Logtable record);

    int insertSelective(Logtable record);

    List<Logtable> selectByExample(LogtableExample example);

    Logtable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Logtable record, @Param("example") LogtableExample example);

    int updateByExample(@Param("record") Logtable record, @Param("example") LogtableExample example);

    int updateByPrimaryKeySelective(Logtable record);

    int updateByPrimaryKey(Logtable record);
}
