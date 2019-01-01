package com.diaosichengxuyuan.spring.cloud.provider.order1.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@RestController("order1Controller")
@RequestMapping(value = "order")
public class Order1Controller {

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Order findById(@PathVariable Long id) {
        return Order.builder().id(id).name("liuhaipeng" + id).age(20).build();
    }
}
