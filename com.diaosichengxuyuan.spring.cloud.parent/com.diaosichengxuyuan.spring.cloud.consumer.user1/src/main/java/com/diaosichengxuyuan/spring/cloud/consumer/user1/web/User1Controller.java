package com.diaosichengxuyuan.spring.cloud.consumer.user1.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@RestController("user1Controller")
@RequestMapping(value = "user1")
public class User1Controller {

    private static final String MICROSERVICE_NAME = "com.diaosichengxuyuan.spring.cloud.provider.order";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${name}")
    private String name;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Order findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://" + MICROSERVICE_NAME + "/order/findById/" + id, Order.class);
    }

    @GetMapping(value = "/userInstance")
    public String logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(MICROSERVICE_NAME);
        return String.format("当前选择的服务实例：%s，主机：%s，端口：%s", serviceInstance.getServiceId(), serviceInstance.getHost(),
            serviceInstance.getPort());
    }

    @GetMapping("/getNameFromConfig")
    public String getNameFromConfig(){
       return this.name;
    }

    public Order findByIdFallback(Long id){
        return Order.builder().id(-1L).name("默认用户").age(-1).build();
    }
}
