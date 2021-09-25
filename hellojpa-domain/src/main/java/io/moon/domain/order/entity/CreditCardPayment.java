/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.order.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 신용카드 결제(서브타입).
 */
@Entity
@DiscriminatorValue(value = OrderPayment.PaymentMethod.Values.CREDIT_CARD)
@NoArgsConstructor
public class CreditCardPayment extends OrderPayment {

    private String cardNumber;

    public CreditCardPayment(final Long amount, final String cardNumber) {
        super(PaymentMethod.CREDIT_CARD, amount);
        this.cardNumber = cardNumber;
    }
}
