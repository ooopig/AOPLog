package com.example.aoplog.aspect;

import com.example.aoplog.annotation.Log;
import com.example.aoplog.listener.EventPubListener;
import com.example.aoplog.pojo.SysLog;
import com.example.aoplog.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@Aspect
@Component
public class SysLogAspect {
    private final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
    @Autowired
    private EventPubListener eventPubListener;

    /**
     * 以注解所标注的方法作为切入点
     */

    @Pointcut("@annotation(com.example.aoplog.annotation.Log)")
    public void sysLog(){}

    /**
     * 通知
     */
    @After("sysLog()")
    public void doAfter(JoinPoint joinPoint){
        Log log = ((MethodSignature) joinPoint.getSignature()).getMethod()
                .getAnnotation(Log.class);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String method = request.getMethod();
        String url = request.getRequestURL().toString();
        String ip = IpUtils.getIpAddr(request);
        SysLog sysLog = new SysLog();
        sysLog.setBusinessType(log.businessType().getCode());
        sysLog.setTitle(log.title());
        sysLog.setRequestMethod(method);
        sysLog.setOperIp(ip);
        sysLog.setOperUrl(url);
        // 从登录中token获取登录人员信息即可
        sysLog.setOperName("我是测试人员");
        sysLog.setOperTime(LocalDateTime.now());
        // 发布消息
        eventPubListener.pushListener(sysLog);
        System.out.println("joinpoint=====>"+ joinPoint.toString());
        logger.info("=======日志发送成功，内容：{}",sysLog);

    }

}
