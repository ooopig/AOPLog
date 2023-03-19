package com.example.aoplog.listener;

import com.example.aoplog.pojo.SysLog;
import com.example.aoplog.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyEventListener {
    @Autowired
    private TestService testService;

    // 开启线程池异步
    @Async("asyncExecutor")
    // 开启监听
    @EventListener(SysLog.class)
    public void saveSysLog(SysLog event) {
        log.info("=====即将异步保存到数据库======");
        testService.saveLog(event);
    }
}
