package org.glsid3.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glsid3.billingservice.entities.Customer;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class InvoiceResponseDto {
    private String id;
    private Date date;
    private BigDecimal amount;
    private Customer customer;
}
