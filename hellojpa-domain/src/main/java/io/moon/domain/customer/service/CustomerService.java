/*
 * Copyright 2019. OPENTEST. All rights reserved.
 */

package io.moon.domain.customer.service;

import io.moon.domain.customer.entity.Customer;
import io.moon.domain.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final CustomerRepository repository;

    public void saveCustomer(final Customer customer) {
        repository.save(customer);
    }

    public Customer findOne(final Long customerId) {
        return repository.findOne(customerId);
    }

    public void removeCustomer(final Customer customer) {
        repository.delete(customer);
    }

    public void removeCustomer(final Long customerId) {
        repository.delete(customerId);
    }

}
