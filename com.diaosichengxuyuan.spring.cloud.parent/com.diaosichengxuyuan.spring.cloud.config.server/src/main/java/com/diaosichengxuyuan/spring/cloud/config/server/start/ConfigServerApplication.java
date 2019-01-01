package com.diaosichengxuyuan.spring.cloud.config.server.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author liuhaipeng
 * @date 2019/1/1
 */
@SpringBootApplication(scanBasePackages = "com.diaosichengxuyuan.spring.cloud.config.server")
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
