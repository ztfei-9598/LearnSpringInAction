package com.tangxin.mall.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    public String goodsList() {
        return restTemplate.getForObject("http://SERVICE-GOODS/goods/goods/list", String.class);
    }

}
