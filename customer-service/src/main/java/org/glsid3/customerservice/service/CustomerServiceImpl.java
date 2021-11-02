package org.glsid3.customerservice.service;

import org.glsid3.customerservice.dto.CustomerRequestDto;
import org.glsid3.customerservice.dto.CustomerResponseDto;
import org.glsid3.customerservice.entities.Customer;
import org.glsid3.customerservice.mappers.CustomerMapper;
import org.glsid3.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {

        Customer customer= customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        customerRepository.save(customer);
        CustomerResponseDto customerResponseDto= customerMapper.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto) {
        Customer customer= customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        customerRepository.save(customer);
        CustomerResponseDto customerResponseDto= customerMapper.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    @Override
    public List<CustomerResponseDto> listCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtoList= customers.stream().map(
                customer -> customerMapper.customerToCustomerResponseDto(customer)).collect(Collectors.toList());

        return customerResponseDtoList;
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDto(customer);
    }
}
