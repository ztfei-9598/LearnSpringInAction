package com.tangxin.mall.order.controller;

import com.tangxin.mall.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/goods")
    public String goods() {
        return orderService.goodsList();
    }

}
