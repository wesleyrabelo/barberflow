package com.barberflow.barberflow.customer.repository;

import com.barberflow.barberflow.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Customer, Long> {
}
