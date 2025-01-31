package com.barberflow.barberflow.customer.controller;

import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.mapper.CustomerMapper;
import com.barberflow.barberflow.customer.entity.Customer;
import com.barberflow.barberflow.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TO-DO :
// Criar DTO,
// Adicionar RestControllerAdvice
// Pagination

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper){
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Customer> signupCustomer(@RequestBody CustomerSignupReceiveDto dto){
        Customer customer = customerMapper.signupDtoToCustomer(dto);
        return ResponseEntity.ok().body(customerService.saveCustomer(customer));
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.updateCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(customerService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Customer> findByEmail(@RequestBody String email){
        return ResponseEntity.ok().body(customerService.findByEmail(email));
    }
}
