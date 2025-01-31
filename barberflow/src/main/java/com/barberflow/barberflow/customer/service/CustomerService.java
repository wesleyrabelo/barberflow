package com.barberflow.barberflow.customer.service;


import com.barberflow.barberflow.customer.entity.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
    Customer findById(Long id);
    Customer findByEmail(String email);
}
