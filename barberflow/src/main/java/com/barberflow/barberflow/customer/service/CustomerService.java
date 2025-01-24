package com.barberflow.barberflow.customer.service;


import com.barberflow.barberflow.customer.entity.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer findById(Long id);
    Customer findByEmail(String email);
}
