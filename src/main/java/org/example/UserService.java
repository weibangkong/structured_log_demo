package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void processUser(String name, int age) {
        // 设置 MDC 信息
//        MDC.put("method", "processUser");
//        MDC.put("class", "UserService");
        MDC.put("traceId", "trace-" + 1111111);
        MDC.put("spanId", "span-" + 123456);
//        MDC.put("parentId", "parent-" + UUID.randomUUID().toString());
//        MDC.put("sampled", "true");
//        MDC.put("flags", "0");
//        MDC.put("priority", "1");
//        MDC.put("category", "application");
//        MDC.put("userName", name);
//        MDC.put("userAge", String.valueOf(age));

        try {
            // 记录开始处理的信息
            logger.info("开始处理用户信息");

            // 验证用户年龄
            if (age < 0) {
                logger.warn("用户年龄无效: {}", age);
                throw new IllegalArgumentException("年龄不能为负数");
            }

            // 模拟业务处理
            try {
                // 记录处理过程
                logger.debug("正在处理用户 {} 的信息", name);
                
                // 模拟一些处理逻辑
                Thread.sleep(100);
                
                // 记录处理结果
                logger.info("用户信息处理完成: name={}, age={}", name, age);
            } catch (InterruptedException e) {
                logger.error("处理用户信息时发生中断", e);
                Thread.currentThread().interrupt();
            }
        } finally {
            // 清理 MDC 信息
            MDC.remove("method");
            MDC.remove("class");
            MDC.remove("traceId");
            MDC.remove("spanId");
            MDC.remove("parentId");
            MDC.remove("sampled");
            MDC.remove("flags");
            MDC.remove("priority");
            MDC.remove("category");
            MDC.remove("userName");
            MDC.remove("userAge");
        }
    }
} 