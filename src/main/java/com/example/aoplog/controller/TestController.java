package com.example.aoplog.controller;


import com.example.aoplog.annotation.Log;
import com.example.aoplog.constant.BusinessTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
    @Log(title = "测试呢",businessType = BusinessTypeEnum.INSERT)
    @GetMapping("/saveLog")
    public void saveLog(){
        log.info("我就是来测试一下是否成功！");
    }
}
