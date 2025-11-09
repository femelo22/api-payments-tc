package com.br.lfmelo.adapters.driver.controller;


import com.br.lfmelo.adapters.dtos.order.OrderDTO;
import com.br.lfmelo.adapters.dtos.order.OrderPayment;
import com.br.lfmelo.core.ports.PaymentServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagementos")
public class PaymentController {

    @Autowired
    private PaymentServicePort paymentPort;

    @PostMapping("/submit")
    public ResponseEntity<?> enviaPagamentoMp(@RequestBody OrderPayment dto) {

        OrderDTO orderDto = new OrderDTO(
                dto.order().getId(),
                dto.order().getClientId(),
                dto.order().getCpf(),
                dto.order().getStatus(),
                dto.order().getTotalPrice(),
                dto.order().getDate(),
                dto.order().getItems());

        paymentPort.gerarQrCode(orderDto);
        return null;
    }

}
