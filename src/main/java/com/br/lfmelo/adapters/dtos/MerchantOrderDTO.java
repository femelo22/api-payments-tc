package com.br.lfmelo.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantOrderDTO {
    private Long id;
    private String order_status;
    private String external_reference;
}
