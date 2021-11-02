package org.glsid3.customerservice.web;

import org.glsid3.customerservice.dto.CustomerRequestDto;
import org.glsid3.customerservice.dto.CustomerResponseDto;
import org.glsid3.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerRestApi {
    private CustomerService customerService;

    public CustomerRestApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path="/customers")
    public List<CustomerResponseDto> customers()
    {
        return customerService.listCustomers();
    }

    @PostMapping(path="/customers")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto)
    {
        customerRequestDto.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDto);
    }

    @PutMapping(path="/customers")
    public CustomerResponseDto update(@RequestBody CustomerRequestDto customerRequestDto)
    {
        return customerService.save(customerRequestDto);
    }

    @GetMapping(path="/customers/{id}")
    public CustomerResponseDto customer(@PathVariable String id)
    {
        return customerService.getCustomer(id);
    }
}
