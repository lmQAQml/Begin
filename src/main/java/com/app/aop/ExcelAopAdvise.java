package com.app.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class ExcelAopAdvise {

    // 1. 通过路径指定方法
//    @Pointcut("execution(* com.app.controller.EasyExcelController.*(..))")
    // 2. 自定义注解方式指定方法
    @Pointcut("@annotation(com.app.annotation.ExcelAopAnnotation)")
    public void pointcut() {

    }

    @Before(value = "pointcut()", argNames = "joinPoint")
    public void excel(JoinPoint joinPoint) {
        log.info("Excel接口:{} \t 开始导出excel,参数: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }
}
