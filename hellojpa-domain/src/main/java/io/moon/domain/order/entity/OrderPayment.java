/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.entity;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <h1>주문 결제(수퍼타입)</h1>
 *
 * <h2>1. {@link javax.persistence.InheritanceType#JOINED}일 경우</h2>
 * <ul>
 *  <li>단일 테이블로 생성된다.</li>
 *  <li>{@link DiscriminatorColumn @DiscriminatorColumn}을 선언하지 않아도 기본적으로 `dtype`컬럼이 생성된다.</li>
 * </ul>
 *
 * <h2>2. {@link javax.persistence.InheritanceType#SINGLE_TABLE}일 경우</h2>
 * <ul>
 *  <li>단일 테이블로 생성된다.</li>
 *  <li>{@link DiscriminatorColumn @DiscriminatorColumn}을 선언하지 않아도 기본적으로 `dtype`컬럼이 생성된다.</li>
 * </ul>
 *
 * <h2>3. {@link javax.persistence.InheritanceType#TABLE_PER_CLASS}일 경우</h2>
 * <ul>
 *  <li>단일 테이블로 생성된다.</li>
 *  <li>{@link DiscriminatorColumn @DiscriminatorColumn}을 선언하지 않아도 기본적으로 `dtype`컬럼이 생성된다.</li>
 * </ul>
 */
@Entity
@Table(name = "T_ORDER_PAYMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "method", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
public class OrderPayment implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false, insertable = false, updatable = false)
    protected PaymentMethod method;

    protected Long amount;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    protected Order order;

    public enum PaymentMethod {
        CREDIT_CARD,
        MOBILE_PHONE;

        static class Values {
            static final String CREDIT_CARD = "CREDIT_CARD";
            static final String MOBILE_PHONE = "MOBILE_PHONE";
        }
    }

    public OrderPayment(PaymentMethod method, Long amount) {
        this.method = method;
        this.amount = amount;
    }

    public boolean isCreditCard() {
        return this.method.equals(PaymentMethod.CREDIT_CARD);
    }

    public boolean isMobilePhone() {
        return this.method.equals(PaymentMethod.MOBILE_PHONE);
    }

}
