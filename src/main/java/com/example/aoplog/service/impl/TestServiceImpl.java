package com.example.aoplog.service.impl;

import com.example.aoplog.mapper.TestMapper;
import com.example.aoplog.pojo.SysLog;
import com.example.aoplog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public int saveLog(SysLog event) {
        return testMapper.insert(event);
    }
}
