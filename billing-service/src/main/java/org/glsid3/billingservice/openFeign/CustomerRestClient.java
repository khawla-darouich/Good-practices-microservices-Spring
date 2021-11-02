package org.glsid3.billingservice.openFeign;

import org.glsid3.billingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path = "/api/customers/{id}")
    Customer getCustomer(@PathVariable String id);
    @GetMapping("/api/customers")
    List<Customer> allCustomers();

}
