package com.diaosichengxuyuan.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@SpringBootApplication(scanBasePackages = "com.diaosichengxuyuan.spring.cloud.eureka")
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
