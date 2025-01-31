package com.barberflow.barberflow.customer.dto.mapper;

import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {

    Customer signupDtoToCustomer(CustomerSignupReceiveDto dto);
}
