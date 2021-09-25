/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.customer.repository;

import io.moon.domain.customer.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(final Customer customer) {
        em.persist(customer);
    }

    @Transactional
    public void delete(final Customer customer) {
        em.remove(customer);
    }

    @Transactional
    public void delete(final Long customerId) {
        em.remove(findOne(customerId));
    }

    public Customer findOne(final Long id) {
        return em.find(Customer.class, id);
    }
}
