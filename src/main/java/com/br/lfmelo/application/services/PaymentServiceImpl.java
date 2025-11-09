package com.br.lfmelo.application.services;

import com.br.lfmelo.adapters.dtos.mercadopago.MercadoPagoItemDTO;
import com.br.lfmelo.adapters.dtos.mercadopago.MercadoPagoRequestDTO;
import com.br.lfmelo.adapters.dtos.mercadopago.MercadoPagoResponseDTO;
import com.br.lfmelo.adapters.dtos.order.OrderDTO;
import com.br.lfmelo.adapters.dtos.product.ProductDTO;
import com.br.lfmelo.core.model.OrderItem;
import com.br.lfmelo.core.model.Payment;
import com.br.lfmelo.core.ports.PaymentRepositoryPort;
import com.br.lfmelo.core.ports.PaymentServicePort;
import com.br.lfmelo.infrastructure.exceptions.IntegracaoMercadoPagoException;
import com.br.lfmelo.infrastructure.http.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentServicePort {

    @Autowired
    PaymentRepositoryPort repository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mercadopago.api.url}")
    private String mercadoPagoUrl;

    @Value("${mercadopago.token}")
    private String mercadoPagoToken;

    @Value("${mercadopago.notification-url}")
    private String notificationUrl;

    @Value("${mercadopago.collector-id}")
    private String collectorId;

    @Value("${mercadopago.pos-id}")
    private String posId;


    public String gerarQrCode(OrderDTO orderDTO) {
        try {
            List<MercadoPagoItemDTO> itens = mapOrderItems(orderDTO.items());
            MercadoPagoRequestDTO mpRequest = new MercadoPagoRequestDTO();
            //verificar como faremos, pois ID é criado apenas após persistir no banco
            mpRequest.setExternal_reference(orderDTO.id().toString());
            mpRequest.setNotification_url(notificationUrl);
            mpRequest.setTotal_amount(orderDTO.totalPrice());
            mpRequest.setItems(itens);
            mpRequest.setTitle("Pedido lanchonete");
            mpRequest.setDescription("Pedido lanchonete");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(mercadoPagoToken);

            HttpEntity<MercadoPagoRequestDTO> entity = new HttpEntity<>(mpRequest, headers);

            ResponseEntity<MercadoPagoResponseDTO> response = restTemplate.postForEntity(
                    mercadoPagoUrl,
                    entity,
                    MercadoPagoResponseDTO.class,
                    collectorId,
                    posId
            );

            return response.getBody().getQr_data();

        } catch (Exception e) {
            throw new IntegracaoMercadoPagoException("Erro ao gerar QR Code com Mercado Pago: " + e.getMessage(), e);
        }
    }

    private List<MercadoPagoItemDTO> mapOrderItems(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem -> {
                    ProductDTO product = productClient.getProductById(orderItem.getProduct().id());
                    return new MercadoPagoItemDTO(
                            product.id().toString(),
                            product.category().toString(),
                            product.name(),
                            product.description(),
                            orderItem.getAmount(),
                            "unit",
                            product.price(),
                            product.price().multiply(BigDecimal.valueOf(orderItem.getAmount()))
                    );
                })
                .collect(Collectors.toList());
    }



}
