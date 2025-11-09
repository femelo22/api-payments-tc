package com.br.lfmelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentWebhookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentWebhookApplication.class, args);
	}

}
