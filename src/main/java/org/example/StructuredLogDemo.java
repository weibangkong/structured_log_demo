package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class StructuredLogDemo {
    private static final Logger logger = LoggerFactory.getLogger(StructuredLogDemo.class);

    public static void main(String[] args) {
        // 设置全局 MDC 信息
        MDC.put("traceId", "trace-" + 1111111);
        MDC.put("spanId", "span-" + 123456);

        MDC.put("parentId", "parent-" + System.currentTimeMillis());
        MDC.put("sampled", "true");
        MDC.put("flags", "0");
        MDC.put("priority", "1");
        MDC.put("category", "application");

        try {
            // 创建服务实例并运行示例
            UserService userService = new UserService();
            userService.processUser("张三", 25);
            userService.processUser("李四", 30);

            // 模拟异常场景
            try {
                userService.processUser("王五", -1);
            } catch (IllegalArgumentException e) {
                logger.error("处理用户信息时发生错误", e);
            }
        } finally {
            // 清理全局 MDC 信息
            MDC.remove("traceId");
            MDC.remove("spanId");

            MDC.remove("parentId");
            MDC.remove("sampled");
            MDC.remove("flags");
            MDC.remove("priority");
            MDC.remove("category");
        }
    }
} 