package com.fruitsalesplatform.log;

import org.apache.log4j.Logger;

public class LogAspect {
     /**
      * * 操作日志文件名
      * */
     private static final String OPERATION_LOG_NAME = "operationLog";
     private static final String LOG_FORMATTER = "%s.%s - %s";
     Logger log = Logger.getLogger(OPERATION_LOG_NAME);
}
