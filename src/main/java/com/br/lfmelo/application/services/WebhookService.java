package com.br.lfmelo.application.services;

import com.br.lfmelo.adapters.dtos.ConfirmedMessageDto;
import com.br.lfmelo.adapters.dtos.MerchantOrderDTO;
import com.br.lfmelo.core.ports.WebhookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService implements WebhookServicePort {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mercadopago.token}")
    private String mercadoPagoToken;

//    @Autowired
//    private OrderServicePort orderServicePort;

    @Override
    public void receberNotificacao(ConfirmedMessageDto payload) {
        try {
            String resourceUrl = payload.getResource();

            if (resourceUrl == null || resourceUrl.isBlank()) {
                throw new IllegalArgumentException("Payload inválido: resource não informado");
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(mercadoPagoToken);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<MerchantOrderDTO> response = restTemplate.exchange(
                    resourceUrl,
                    HttpMethod.GET,
                    entity,
                    MerchantOrderDTO.class
            );

            MerchantOrderDTO merchantOrder = response.getBody();
            System.out.println("Ordem recebida: " + merchantOrder.getOrder_status());

            //TODO: JOGAR PARA STATIC DEPOIS - "payment_required"
            if ("payment_required".equalsIgnoreCase(merchantOrder.getOrder_status())) {
                // paymentServicePort buscar por order_id (External_reference)
                // Atualizar o status e atualizar o payment



//                Order order = orderServicePort.findById(Long.parseLong(merchantOrder.getExternal_reference()));
//
////                order.getPayment().setStatus(PaymentStatus.IN_PROGRESS);
//                orderServicePort.save(order);
            }


        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar notificação do Mercado Pago", e);
        }

    }
}
