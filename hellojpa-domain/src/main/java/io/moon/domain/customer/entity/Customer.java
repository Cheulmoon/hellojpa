/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.customer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity.
 * <p>
 *  양뱡향관계가 있는 엔티티를 JSON으로 변환할때 무한참조가 발생 할 수 있다.
 *
 *      Could not write JSON: Infinite recursion (StackOverflowError);
 *
 *  이를 방지하기 위해 {@link JsonIdentityInfo}를 사용한다.
 *  1.x 버전에서는 Parent에 {@link com.fasterxml.jackson.annotation.JsonManagedReference}를
 *  child에 {@link com.fasterxml.jackson.annotation.JsonBackReference}를 사용해야 했다.
 * </p>
 *
 * @see <a href="https://ict-nroo.tistory.com/128">상속관계 매핑 전략(@Inheritance, @DiscriminatorColumn)</a>
 * @see <a href="https://velog.io/@aidenshin/내가-생각하는-JPA-엔티티-작성-원칙">JPA 엔티티 작성 - Setter 금지</a>
 * @see <a href="https://perfectacle.github.io/2021/06/13/entity-manager-persist-vs-merge/">persist vs merge</a>
 * @see <a href="https://tech.junhabaek.net/hibernate-jpa-entitymanager-핵심-기능-정리-3d0d9ff439a2">Hibernate JPA EntityManager 핵심 기능 정리</a>
 * @see <a href="https://umanking.github.io/2019/04/12/jpa-persist-merge/">save메서드로 살펴보는 persist와 merge 개념</a>
 * @see <a href="https://www.vincenzoracca.com/en/blog/framework/jpa/jpa-em/">EntityManager: Application managed and Container managed</a>
 */
@Entity
@Table(name = "T_CUSTOMER")
public class Customer implements Serializable {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    private String name;

    @Getter
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillingAddress> billingAddresses = new ArrayList<>();

    public void addBillingAddress(final BillingAddress billingAddress) {
        billingAddresses.add(billingAddress);
        billingAddress.setCustomer(this);
    }

    public void removeBillingAddress(final BillingAddress billingAddress) {
        billingAddresses.remove(billingAddress);
        billingAddress.setCustomer(null);
    }

}
