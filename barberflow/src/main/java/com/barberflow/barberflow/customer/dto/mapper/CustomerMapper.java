package com.barberflow.barberflow.customer.dto.mapper;

import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupResponseDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateReceiveDto;
import com.barberflow.barberflow.customer.entity.Customer;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {
    Customer customerReceiveDtoToCustomer(CustomerSignupReceiveDto dto);
    CustomerSignupResponseDto customerToSignupResponseDto(Customer customer);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateCustomerFromDto(CustomerUpdateReceiveDto dto, @MappingTarget Customer customer);
}
