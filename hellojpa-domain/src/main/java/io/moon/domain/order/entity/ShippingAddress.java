/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.entity;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 배송지.
 */
@Entity
@Table(name = "T_SHIPPING_ADDRESS")
@NoArgsConstructor
public class ShippingAddress implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String zipCode;

    private String recipient;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    public ShippingAddress(String zipCode, String receipient) {
        this.zipCode = zipCode;
        this.recipient = receipient;
    }

}
