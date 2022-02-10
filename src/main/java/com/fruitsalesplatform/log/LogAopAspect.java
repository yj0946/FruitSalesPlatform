package com.fruitsalesplatform.log;

import com.alibaba.fastjson.JSON;
import com.fruitsalesplatform.annotation.LogAnno;
import com.fruitsalesplatform.entity.Logtable;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.LogtableService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
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
        // 1.方法执行前的处理，相当于前置通知
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        // 获取方法
        Method method = methodSignature.getMethod();
        Method realMethod = pjp.getTarget().getClass().getDeclaredMethod(pjp.getSignature().getName(), method.getParameterTypes());

        // 获取方法上面的注解
        LogAnno logAnno = realMethod.getAnnotation(LogAnno.class);

        if (logAnno == null) {
            return null;
        }

        // 获取操作描述的属性值
        String operateType = logAnno.operateType();

        // 创建一个日志对象(准备记录日志)
        Logtable logtable = new Logtable();
        logtable.setOperatetype(operateType);



        Object result = null;
        try {
            // 整合了Struts，所有用这种方式获取session中属性(亲测有效)
            ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = attr.getRequest();
            Map<String, Cookie> cookieMap = readCookieMap(request);
            if(!cookieMap.containsKey("userinfo")){  //判断cookieMap是否含有该key
                return null;
            }
            Object objUserJson = URLDecoder.decode(cookieMap.get("userinfo").getValue(), "utf-8");
            String strJson = JSON.toJSONString(objUserJson);
            objUserJson = JSON.parse(strJson);

            User user = JSON.parseObject(objUserJson.toString(), User.class);//获取session中的user对象进而获取操作人名字
            logtable.setOperateor(user.getUserName());// 设置操作人

            //让代理方法执行
            result = pjp.proceed();
            // 2.相当于后置通知(方法成功执行之后走这里)
            logtable.setOperateresult("正常");// 设置操作结果
        } catch (Exception e) {
            // 3.相当于异常通知部分
            logtable.setOperateresult("失败");// 设置操作结果
        } finally {
            // 4.相当于最终通知
            logtable.setOperatedate(new Date());// 设置操作日期
            logtableService.addLog(logtable);// 添加日志记录
        }
        return result;
    }

    /**
     * 将cookie封装成map
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request){
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();        //获取所有的cookie值
        if(cookies != null){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
