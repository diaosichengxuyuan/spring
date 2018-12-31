package com.diaosichengxuyuan.spring.cloud.provider.order1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@RestController("order1Controller")
@RequestMapping(value = "order")
public class Order1Controller {

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Order findById(@RequestParam Long id) {
        return Order.builder().id(id).name("liuhaipeng" + id).age(20).build();
    }
}
