package org.glsid3.billingservice;

import org.glsid3.billingservice.dto.InvoiceRequestDto;
import org.glsid3.billingservice.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(InvoiceService invoiceService)
    {
        return args -> {
            invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(98000),"C01"));
            invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(976000),"C02"));
        };
    }

}

