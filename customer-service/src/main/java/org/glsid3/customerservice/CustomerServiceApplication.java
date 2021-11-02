package org.glsid3.customerservice;

import org.glsid3.customerservice.dto.CustomerRequestDto;
import org.glsid3.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService) {
        return args ->{
            customerService.save(new CustomerRequestDto("C01","Adria","adria@glsid3.com"));
            customerService.save(new CustomerRequestDto("C02","ENSET","enset@glsid3.com"));

        };
    }
}
