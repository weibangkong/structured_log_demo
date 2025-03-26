package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 日志切面
 *  切面的作用是处理MDC，向MDC容器中添加一部分参数，不清楚一些现成的结构化日志框架是不是也是这样实现的,可能因为
 */
@Aspect
@Component
public class LogAspect {
    
    @Around("execution(* org.example.service..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String traceId = "trace-" + UUID.randomUUID().toString();
        String spanId = "span-" + UUID.randomUUID().toString();
        
        try {
            // 设置MDC信息
            MDC.put("traceId", traceId);
            MDC.put("spanId", spanId);
            MDC.put("method", point.getSignature().getName());
            MDC.put("class", point.getTarget().getClass().getSimpleName());
            
            // 执行原方法
            return point.proceed();
        } finally {
            // 清理MDC信息
            MDC.remove("traceId");
            MDC.remove("spanId");
            MDC.remove("method");
            MDC.remove("class");
        }
    }
} 