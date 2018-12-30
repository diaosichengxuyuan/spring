package com.diaosichengxuyuan.spring.cloud.consumer.user1.web;

import com.diaosichengxuyuan.spring.cloud.provider.order1.web.Order1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@RestController("user1Controller")
@RequestMapping(value = "user1")
public class User1Controller {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Order1 findById(@RequestParam Long id) {
        return restTemplate.getForObject("http://localhost:10001/order1/findById?id=" + id, Order1.class);
    }
}
