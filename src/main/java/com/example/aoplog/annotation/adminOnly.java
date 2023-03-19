package com.example.aoplog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解使用@interface
 * @Retention: 注解在什么时候运行
 * 使用时，只需要在相应方法上加上注解，就会进行拦截
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface adminOnly {
}
