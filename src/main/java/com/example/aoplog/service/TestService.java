package com.example.aoplog.service;

import com.example.aoplog.pojo.SysLog;
import org.springframework.stereotype.Service;

@Service
public interface TestService {
    int saveLog(SysLog event);
}
