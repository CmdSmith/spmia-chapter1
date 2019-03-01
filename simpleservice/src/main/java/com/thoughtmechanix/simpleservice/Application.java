package com.thoughtmechanix.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

// 告诉Spring Boot框架，该类是Spring Boot服务的入口点
@SpringBootApplication
// 告诉Spring Boot，要将该类中的代码公开为Spring RestController类
@RestController
// 此应用程序中公开的所有URL讲义/hello 前缀开头
@RequestMapping(value="hello")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Spring Boot公开为一个基于GET方法的REST端点，它将使用两个参数，即firstName和lastName
    @RequestMapping(value="/{firstName}/{lastName}",method = RequestMethod.GET)
    public String hello( @PathVariable("firstName") String firstName,
                         @PathVariable("lastName") String lastName) {

        // 将 URL 传入的firstName和lastName参数映射为传递给hello方法的两个变量
        // 返回一个手动构建的简单JSON字符串。
        // 在第二张中我们不需要创建任何JSON
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }
}
