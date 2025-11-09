package com.br.lfmelo.adapters.driven.repository;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import com.br.lfmelo.core.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringPaymentRepository extends JpaRepository<PaymentEntity, Long> {
    Optional<PaymentEntity> findByOrderId(Long orderId);
}
