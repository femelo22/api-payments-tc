package com.br.lfmelo.adapters.driven.entities;

import com.br.lfmelo.core.model.enums.PaymentStatus;
import com.br.lfmelo.core.model.enums.PaymentType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaymentEntity {
    @Id
    private Long id;
    @Indexed(unique = true)
    private Long orderId;
    private PaymentType type;
    private PaymentStatus status;
    private String qrCode;
}
