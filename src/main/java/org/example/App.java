package org.example;

import org.example.controller.TestController;
import org.example.service.UserServiceWithAnnotiaion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        TestController testController = context.getBean(TestController.class);
        testController.Test();
//        UserServiceWithAnnotiaion userService = context.getBean(UserServiceWithAnnotiaion.class);
//
//        // 测试正常场景
//        userService.processUser("张三", 25);
//        userService.processUser("李四", 30);
//
//        // 测试异常场景
//        try {
//            userService.processUser("王五", -1);
//        } catch (IllegalArgumentException e) {
//            // 异常已经在service中记录
//        }
    }
} 