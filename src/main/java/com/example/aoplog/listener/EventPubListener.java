package com.example.aoplog.listener;

import com.example.aoplog.aspect.SysLogAspect;
import com.example.aoplog.pojo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPubListener {
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 使用应用上下文 对 日志事件进行发布
     * @param sysLog
     */
    public void pushListener(SysLog sysLog){
        applicationContext.publishEvent(sysLog);
    }
}
