/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * 주문.
 */
@Entity
@Table(name = "T_ORDER")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private Long customerId;

    private LocalDateTime createdAt;

    @Getter
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderPayment> payments = new ArrayList<>();

    @Setter
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @PrePersist
    void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    public Order() {
    }

    /*
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    */

    public void addOrderDetail(final OrderDetail orderDetail) {
        this.orderDetails.add(orderDetail);
    }

    /*
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    */

    public void addOrderPayment(final OrderPayment payment) {
        this.payments.add(payment);
    }

    /*
    public List<OrderPayment> getPayments() {
        return payments;
    }
    */

    /*
    public void setShippingAddress(ShippingAddress shippingAddress) {
        // Validation logic here
        this.shippingAddress = shippingAddress;
    }
    */

    public void changeShippingAddress(ShippingAddress shippingAddress) {
        // Validation logic here
        setShippingAddress(shippingAddress);
    }

    public void placeOrder() {
        this.validate();
        // Other validation policy
    }

    private void validate() {
        this.validatePaymentMethodPolicyOfOrderDetails();
    }

    private void validatePaymentMethodPolicyOfOrderDetails() {
        boolean contains = this.getOrderDetails()
                .stream()
                .anyMatch(
                        lineItem -> lineItem
                                .getProductId()
                                .equalsIgnoreCase("P-0004")
                );

        if (contains) {
            if (this.getPayments().size() != 1
                    || this.getPayments()
                            .stream()
                            .anyMatch(
                                    orderPayment -> !orderPayment.isCreditCard()
                            )
            ) {
                throw new IllegalArgumentException("P-0004 상품은 신용카드로만 결제가 가능합니다");
            }
        }
    }
}
