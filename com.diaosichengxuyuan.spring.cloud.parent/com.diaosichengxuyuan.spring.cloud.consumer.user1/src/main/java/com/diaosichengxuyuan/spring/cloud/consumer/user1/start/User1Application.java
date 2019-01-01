package com.diaosichengxuyuan.spring.cloud.consumer.user1.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@SpringBootApplication(scanBasePackages = "com.diaosichengxuyuan.spring.cloud.consumer.user1")
@EnableEurekaClient
@EnableHystrix
public class User1Application {

    public static void main(String[] args) {
        SpringApplication.run(User1Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
