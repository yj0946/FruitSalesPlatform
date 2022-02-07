package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.Logtable;

import java.sql.SQLException;

public interface LogtableService {
    /**
     * 增加日志
     * @param log
     * @return
     * @throws SQLException
     */
    public boolean addLog(Logtable log) throws SQLException;
}
