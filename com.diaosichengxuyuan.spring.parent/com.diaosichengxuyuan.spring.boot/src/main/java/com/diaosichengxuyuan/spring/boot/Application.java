package com.diaosichengxuyuan.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.diaosichengxuyuan.spring.boot")
@MapperScan(basePackages = "com.diaosichengxuyuan.spring.boot.dao.test")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

