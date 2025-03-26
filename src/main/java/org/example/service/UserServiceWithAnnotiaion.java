package org.example.service;

import org.example.annotation.StructuredLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author: weibang kong
 * @date: 2025-03-26 11:39:40
 */
@Service
public class UserServiceWithAnnotiaion {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceWithAnnotiaion.class);

    @StructuredLog(description = "处理用户信息", logParams = true, logResult = false)
    public void processUser(String name, int age) {
        // 验证用户年龄
        if (age < 0) {
            logger.warn("用户年龄无效: {}", age);
            throw new IllegalArgumentException("年龄不能为负数");
        }

        // 模拟业务处理
        try {
            // 模拟一些处理逻辑
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
