package org.glsid3.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private String id;
    private String name;
    private String email;
}
