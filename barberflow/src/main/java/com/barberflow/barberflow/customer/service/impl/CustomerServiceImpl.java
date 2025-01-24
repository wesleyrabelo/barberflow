package com.barberflow.barberflow.customer.service.impl;

import com.barberflow.barberflow.customer.entity.Customer;
import com.barberflow.barberflow.customer.repository.CustomerRepository;
import com.barberflow.barberflow.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    //Apesar da anotação @RequiredArgsContrutor do Lombok suportar o uso de @Autowired  é experimental.
    //Mesmo que o Spring não precise da anotação @Autowired quando é apenas um campo no construtor,
    //é bem provável que no futuro haja mais de um. Por isso dá escolha de explicitamente criar o
    //construtor e colocar a @Autowired. Do contrário, bastaria adicionar @RequiredArgsConstructor.
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }
}
