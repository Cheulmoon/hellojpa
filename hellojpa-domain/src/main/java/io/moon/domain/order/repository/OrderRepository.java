/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.repository;

import io.moon.domain.order.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Order order) {
        em.persist(order);
    }

    @Transactional
    public void delete(Order order) {
        em.remove(order);
    }

    public Order findOne(Long orderId) {
        return em.find(Order.class, orderId);
    }
}
