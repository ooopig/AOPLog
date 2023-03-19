package com.example.aoplog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class PoolConfig {

    @Bean
    public ThreadPoolExecutor asyncExecutor(){
        return new ThreadPoolExecutor(
                5,
                10,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(30),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
