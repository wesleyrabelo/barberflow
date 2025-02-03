package com.barberflow.barberflow.customer.service.impl;

import com.barberflow.barberflow.customer.dto.mapper.CustomerMapper;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateReceiveDto;
import com.barberflow.barberflow.customer.entity.Customer;
import com.barberflow.barberflow.customer.repository.CustomerRepository;
import com.barberflow.barberflow.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TO-DO:
//  Criar uma exceção personalizada para os metodos @deleteCustomer, @findById e @findByEmail.
//  Criar a logica do metodo @updateCustomer

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper mapper){
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public Customer saveCustomer(CustomerSignupReceiveDto dto) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, CustomerUpdateReceiveDto dto) {
      Customer saved = findById(id);
      Customer updated = mapper.updateCustomerFromDto(dto, saved);
      return customerRepository.save(updated);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer saved = findById(id);
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }
}
