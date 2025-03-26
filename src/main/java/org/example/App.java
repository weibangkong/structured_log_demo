package org.example;

import org.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        UserService userService = context.getBean(UserService.class);

        // 测试正常场景
        userService.processUser("张三", 25);
        userService.processUser("李四", 30);

        // 测试异常场景
        try {
            userService.processUser("王五", -1);
        } catch (IllegalArgumentException e) {
            // 异常已经在service中记录
        }
    }
} 