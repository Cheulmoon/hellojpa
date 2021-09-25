/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 주문상세.
 */
@Entity
@Table(name = "T_ORDER_DETAIL")
@NoArgsConstructor
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private String productId;

    private String name;

    private Long price;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    public OrderDetail(String productId, String name, Long price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

}
