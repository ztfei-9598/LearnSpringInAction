package com.tacocloud.data;

import com.tacocloud.entity.Order;

public interface OrderRepository {
    Order save(Order order);
}
