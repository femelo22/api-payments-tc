package com.br.lfmelo.adapters.driver.controller;


import com.br.lfmelo.adapters.dtos.ConfirmedMessageDto;
import com.br.lfmelo.core.ports.WebhookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mercadopago")
public class WebhookController {

    @Autowired
    WebhookServicePort webhookServicePort;

    @PostMapping("/notifications")
    public ResponseEntity<Void> receberNotificacao(@RequestBody ConfirmedMessageDto message) {
        try {
            webhookServicePort.receberNotificacao(message);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}