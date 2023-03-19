package com.example.aoplog.aspect;

import com.example.aoplog.service.CheckUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定义切面
 * 切面就是 切点 和 通知 的结合
 */

@Aspect
@Component
public class CheckUserAspect {

    /**
     * aop中要调用的方法
     */
    @Autowired
    private CheckUserService checkUserService;

    /**
     * 切点：要对哪些方法进行增强
     * 在这里要对标注有 adminOnly 注解的方法进行拦截增强
     * checkAdmin()的作用相当于一个替身，运行的时候会替换为真正需要拦截的方法
     */
    @Pointcut("@annotation(com.example.aoplog.annotation.adminOnly)")
    public void checkAdmin(){

    }

//    @Pointcut("execution(* com.example.aoplog.service.*.*(..))")
//    public void checkAdmin(){
//
//    }

    /**
     * 通知
     * 在方法之前增强
     */
    @Before("checkAdmin()")
    public void check(JoinPoint joinPoint){
        checkUserService.check();
        System.out.println(joinPoint);
    }
}
