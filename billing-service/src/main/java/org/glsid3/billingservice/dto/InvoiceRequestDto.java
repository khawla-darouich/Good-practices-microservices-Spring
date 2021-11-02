package org.glsid3.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glsid3.billingservice.entities.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class InvoiceRequestDto {


    private BigDecimal amount;
    private String customerId;
}
