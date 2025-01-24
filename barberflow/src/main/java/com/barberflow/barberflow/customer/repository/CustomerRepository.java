package com.barberflow.barberflow.customer.repository;

import com.barberflow.barberflow.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
