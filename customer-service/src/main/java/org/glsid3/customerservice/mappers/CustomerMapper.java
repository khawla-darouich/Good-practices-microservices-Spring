package org.glsid3.customerservice.mappers;

import org.glsid3.customerservice.dto.CustomerRequestDto;
import org.glsid3.customerservice.dto.CustomerResponseDto;
import org.glsid3.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
     CustomerResponseDto customerToCustomerResponseDto(Customer customer);
     Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}
