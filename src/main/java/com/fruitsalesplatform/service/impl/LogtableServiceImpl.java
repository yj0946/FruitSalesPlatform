package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.mapper.LogtableMapper;
import com.fruitsalesplatform.entity.Logtable;
import com.fruitsalesplatform.service.LogtableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LogtableServiceImpl implements LogtableService {
    @Autowired
    private LogtableMapper logtableMapper;

    @Override
    public boolean addLog(Logtable log) throws SQLException {
        return logtableMapper.insert(log) > 0 ? true : false;
    }
}
