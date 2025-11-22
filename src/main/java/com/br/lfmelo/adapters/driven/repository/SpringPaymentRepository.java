package com.br.lfmelo.adapters.driven.repository;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringPaymentRepository extends MongoRepository<PaymentEntity, Long> {
    Optional<PaymentEntity> findByOrderId(Long orderId);
}
