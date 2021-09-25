/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.service;

import io.moon.domain.order.entity.Order;
import io.moon.domain.order.entity.ShippingAddress;
import io.moon.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final OrderRepository repository;

    public void placeOrder(Order order) {
        order.placeOrder();
        saveOrder(order);
    }

    public void saveOrder(Order order) {
        repository.save(order);
    }

    public void changeShippingAddress(final Long orderId, final ShippingAddress shippingAddress) {
        Order order = repository.findOne(orderId);
        order.changeShippingAddress(shippingAddress);
    }
}
