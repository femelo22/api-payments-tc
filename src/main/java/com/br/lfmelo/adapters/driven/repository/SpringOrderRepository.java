package com.br.lfmelo.adapters.driven.repository;

import com.br.lfmelo.adapters.driven.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringOrderRepository extends JpaRepository<OrderEntity, Long>{
}
