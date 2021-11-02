package org.glsid3.billingservice.mappers;

import org.glsid3.billingservice.dto.InvoiceRequestDto;
import org.glsid3.billingservice.dto.InvoiceResponseDto;
import org.glsid3.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDto invoiceResponseDto);
    InvoiceResponseDto fromInvoice(Invoice invoice);

}
