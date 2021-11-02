package org.glsid3.billingservice.service;

import org.glsid3.billingservice.dto.InvoiceRequestDto;
import org.glsid3.billingservice.dto.InvoiceResponseDto;
import org.glsid3.billingservice.entities.Customer;
import org.glsid3.billingservice.entities.Invoice;
import org.glsid3.billingservice.exception.CustomerNotFoundException;
import org.glsid3.billingservice.mappers.InvoiceMapper;
import org.glsid3.billingservice.openFeign.CustomerRestClient;
import org.glsid3.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto) {
        Customer customer=null;
        try {
            customer=customerRestClient.getCustomer(invoiceRequestDto.getCustomerId());
        }catch (Exception e)
        {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDto);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        invoice.setCustomer(customer);
        invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public InvoiceResponseDto update(InvoiceRequestDto invoiceRequestDto) {
        return null;
    }

    @Override
    public InvoiceResponseDto getInvoice(String invoiceId) {
       Invoice invoice=invoiceRepository.findById(invoiceId).get();
        Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDto> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices=invoiceRepository.findByCustomerId(customerId);
        invoices.forEach(invoice -> {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        });
        return invoices.stream().map(
                invoice ->invoiceMapper.fromInvoice(invoice)
        ).collect(Collectors.toList());


    }

    @Override
    public List<InvoiceResponseDto> invoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        invoices.forEach(invoice -> {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        });
        return invoices.stream().map(
                invoice ->invoiceMapper.fromInvoice(invoice)
        ).collect(Collectors.toList());
    }
}
