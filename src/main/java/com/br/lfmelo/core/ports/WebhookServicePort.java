package com.br.lfmelo.core.ports;

import com.br.lfmelo.adapters.dtos.ConfirmedMessageDto;

public interface WebhookServicePort {
    void receberNotificacao(ConfirmedMessageDto message);
}
