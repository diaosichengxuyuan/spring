package com.diaosichengxuyuan.spring.cloud.consumer.user1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Order findById(@RequestParam Long id) {
        return restTemplate.getForObject("http://" + MICROSERVICE_NAME + "/order/findById?id=" + id, Order.class);
    }

    @GetMapping(value = "/userInstance")
    public String logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(MICROSERVICE_NAME);
        return String.format("当前选择的服务实例：%s，主机：%s，端口：%s", serviceInstance.getServiceId(), serviceInstance.getHost(),
            serviceInstance.getPort());
    }
}
