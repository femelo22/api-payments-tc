package com.br.lfmelo.core.model;

import com.br.lfmelo.core.model.enums.PaymentStatus;
import com.br.lfmelo.core.model.enums.PaymentType;

public class Payment {

    private String id;
    private Long orderId;
    private PaymentType type;
    private PaymentStatus status;
    private String qrCode;

    public Payment(String id, Long orderId, PaymentType type, PaymentStatus status,String qrCode) {
        this.id = id;
        this.orderId = orderId;
        this.type = type;
        this.status = status;
        this.qrCode = qrCode;
    }

    public Payment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymentType getType() {
        return type;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
