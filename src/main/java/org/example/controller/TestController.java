package org.example.controller;

import jakarta.annotation.Resource;
import org.example.annotation.StructuredLog;
import org.example.service.UserService;
import org.example.service.UserServiceWithAnnotiaion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * hahaha
 *
 * @author: weibang kong
 * @date: 2025-03-26 14:15:21
 */
@Component
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private UserService userService;

    @Resource
    private UserServiceWithAnnotiaion userServiceWithAnnotiaion;

    @StructuredLog
    public void Test() {
        logger.info("测试非切面目标对象的日志情况");
        userService.processUser("Tom", 18);
//        userServiceWithAnnotiaion.processUser("Jerry", 20);
    }

}
