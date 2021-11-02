package org.glsid3.customerservice.service;

import org.glsid3.customerservice.dto.CustomerRequestDto;
import org.glsid3.customerservice.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto);
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> listCustomers();
    public CustomerResponseDto getCustomer(String id);
}
