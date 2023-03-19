package com.example.aoplog.annotation;

import com.example.aoplog.constant.BusinessTypeEnum;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default "";

    String title() default "测试模块";

    BusinessTypeEnum businessType() default BusinessTypeEnum.OTHER;
}
