package com.barberflow.barberflow.customer.controller;

import com.barberflow.barberflow.customer.dto.find.CustomerFindByIdResponseDto;
import com.barberflow.barberflow.customer.dto.find.CustomerFindByNameResponseDto;
import com.barberflow.barberflow.customer.dto.mapper.CustomerMapper;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupResponseDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateReceiveDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateResponseDto;
import com.barberflow.barberflow.customer.entity.Customer;
import com.barberflow.barberflow.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TO-DO :
// Criar DTO,
// Adicionar RestControllerAdvice
// Pagination
// Passar a parte de conversão de DTO para o customerService?

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerSignupResponseDto> signupCustomer(@RequestBody CustomerSignupReceiveDto dto){
        return ResponseEntity.ok().body(customerService.saveCustomer(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerUpdateResponseDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateReceiveDto dto){
        return ResponseEntity.ok().body(customerService.updateCustomer(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerFindByIdResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(customerService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CustomerFindByNameResponseDto> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(customerService.findByName(name));
    }
}
