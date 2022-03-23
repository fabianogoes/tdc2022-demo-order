package com.demo.order.infra.integration

import com.demo.order.domain.port.PaymentIntegrationPort
import org.springframework.stereotype.Service

@Service
class PaymentIntegrationAdapter : PaymentIntegrationPort {
    override fun pay(cardNumber: String, value: Long): Boolean {
        println("Sent to payment")
        return true
    }
}