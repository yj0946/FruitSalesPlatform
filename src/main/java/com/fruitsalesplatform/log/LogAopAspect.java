package com.fruitsalesplatform.log;

import com.fruitsalesplatform.annotation.LogAnno;
import com.fruitsalesplatform.entity.Logtable;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.LogtableService;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class LogAopAspect {
    @Autowired
    private LogtableService logtableService;

    /**
     * 环绕通知记录日志通过注解匹配到需要增加日志功能的方法
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.fruitsalesplatform.annotation.LogAnno)")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//        // 1.方法执行前的处理，相当于前置通知
//        // 获取方法签名
//        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//
//        // 获取方法
//        Method method = methodSignature.getMethod();
//
//        // 获取方法上面的注解
//        LogAnno logAnno = method.getAnnotation(LogAnno.class);
//
//        // 获取操作描述的属性值
//        String operateType = logAnno.operateType();
//
//        // 创建一个日志对象(准备记录日志)
//        Logtable logtable = new Logtable();
//        logtable.setOperatetype(operateType);
//
//        // 整合了Struts，所有用这种方式获取session中属性(亲测有效)
//        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("userinfo");//获取session中的user对象进而获取操作人名字
//        logtable.setOperateor(user.getUserName());// 设置操作人
        return null;
    }
}
