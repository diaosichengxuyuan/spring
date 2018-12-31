package com.diaosichengxuyuan.spring.cloud.provider.order2.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@SpringBootApplication(scanBasePackages = "com.diaosichengxuyuan.spring.cloud.provider.order2")
@EnableEurekaClient
public class Order2Application {

    public static void main(String[] args) {
        SpringApplication.run(Order2Application.class, args);
    }

}
