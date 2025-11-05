package com.br.lfmelo.adapters.driven.repository;

import com.br.lfmelo.adapters.driven.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringPaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
