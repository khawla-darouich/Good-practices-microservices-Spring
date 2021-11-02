package org.glsid3.billingservice.service;

import org.glsid3.billingservice.dto.InvoiceRequestDto;
import org.glsid3.billingservice.dto.InvoiceResponseDto;

import java.util.List;

public interface InvoiceService {
    public InvoiceResponseDto save(InvoiceRequestDto invoiceRequestDto);
    public InvoiceResponseDto update(InvoiceRequestDto invoiceRequestDto);
    InvoiceResponseDto getInvoice(String invoiceId);
    List<InvoiceResponseDto> invoicesByCustomerId(String customerId);
    List<InvoiceResponseDto> invoices();
}
