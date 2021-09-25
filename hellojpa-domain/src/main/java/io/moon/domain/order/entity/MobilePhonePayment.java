/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 핸드폰 결제(서브타입).
 */
@Entity
@DiscriminatorValue(value = OrderPayment.PaymentMethod.Values.MOBILE_PHONE)
@NoArgsConstructor
public class MobilePhonePayment extends OrderPayment {

    private String phoneNumber;

    public MobilePhonePayment(final Long amount, final String phoneNumber) {
        super(PaymentMethod.MOBILE_PHONE, amount);
        this.phoneNumber = phoneNumber;
    }
}
