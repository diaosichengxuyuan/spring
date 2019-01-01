package com.diaosichengxuyuan.spring.cloud.provider.order2.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author liuhaipeng
 * @date 2018/12/30
 */
@RestController("order2Controller")
@RequestMapping(value = "order")
public class Order2Controller {

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Order findById(@PathVariable Long id) {
        return Order.builder().id(id).name("liuhaipeng" + id).age(20).build();
    }
}
