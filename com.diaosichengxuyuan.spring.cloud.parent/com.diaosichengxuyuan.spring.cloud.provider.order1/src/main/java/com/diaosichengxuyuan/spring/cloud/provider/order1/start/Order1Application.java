package com.diaosichengxuyuan.spring.cloud.provider.order1.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@SpringBootApplication(scanBasePackages = "com.diaosichengxuyuan.spring.cloud.provider.order1")
public class Order1Application {

    public static void main(String[] args) {
        SpringApplication.run(Order1Application.class, args);
    }

}
