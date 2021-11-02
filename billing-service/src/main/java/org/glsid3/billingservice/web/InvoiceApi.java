package org.glsid3.billingservice.web;

import org.glsid3.billingservice.dto.InvoiceRequestDto;
import org.glsid3.billingservice.dto.InvoiceResponseDto;
import org.glsid3.billingservice.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class InvoiceApi {

    private InvoiceService invoiceService;

    public InvoiceApi(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path="/invoices/{id}")
    public InvoiceResponseDto getInvoice(@PathVariable String id)
    {
        return invoiceService.getInvoice(id);
    }

    @GetMapping(path="/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDto> getInvoicesByCustomer(@PathVariable String customerId)
    {
        return invoiceService.invoicesByCustomerId(customerId);
    }

    @GetMapping(path="/invoices")
    public List<InvoiceResponseDto> getInvoices()
    {
        return invoiceService.invoices();
    }

    @PostMapping("/invoices")
    public InvoiceResponseDto save(@RequestBody InvoiceRequestDto invoiceRequestDto)
    {
        return invoiceService.save(invoiceRequestDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e)
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
