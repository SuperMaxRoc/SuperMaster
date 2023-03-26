package com.roc.SuperMaster.utility.springUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @ClassName MethodLoggingAspect
 * @Author: WangPeng
 * @Description TODO
 * @date 2023/3/26 14:54
 * @Version 1.0.0
 */

@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class MethodLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodLoggingAspect.class);

    @Around("@annotation(com.roc.SuperMaster.utility.springUtil.LogAnnotation)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        // 获取注解的信息
        LogAnnotation logAnnotation = signature.getMethod().getAnnotation(LogAnnotation.class);
        String customMethodName = logAnnotation.value();
        // 处理参数名和参数值
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < parameterNames.length; i++) {
            String name = parameterNames[i];
            Object value = args[i];
            jsonObject.put(name, value);
        }
        logger.error(
                "\n" +
                        "方法执行信息: {}.{}\n" +
                        "方法名称: {}\n" +
                        "入参: {}\n" +
                        "出参: {}\n" +
                        "执行耗时: {} ms",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                customMethodName,
                JSON.toJSONString(jsonObject),
                result,
                elapsedTime
        );
        return result;
    }

    @AfterThrowing(value = "@annotation(com.roc.SuperMaster.utility.springUtil.LogAnnotation)", throwing = "ex")
    public void afterThrowingLog(JoinPoint joinPoint, Exception ex) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        // 获取注解的信息
        LogAnnotation logAnnotation = signature.getMethod().getAnnotation(LogAnnotation.class);
        String customMethodName = logAnnotation.value();
        // 处理参数名和参数值
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < parameterNames.length; i++) {
            String name = parameterNames[i];
            Object value = args[i];
            jsonObject.put(name, value);
        }
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        logger.error(
                "\n" +
                        "方法执行信息: {}.{}\n" +
                        "方法名称: {}\n" +
                        "入参: {}\n" +
                        "异常信息:",
                methodName,
                className,
                customMethodName,
                JSON.toJSONString(jsonObject),
                ex
        );
    }
}