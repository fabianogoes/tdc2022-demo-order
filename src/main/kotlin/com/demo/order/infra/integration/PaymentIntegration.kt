package com.demo.order.infra.integration

import org.springframework.stereotype.Service

interface IPaymentIntegration {
    fun pay(cardNumber: String, value: Long): Boolean
}

@Service
class PaymentIntegration : IPaymentIntegration {
    override fun pay(cardNumber: String, value: Long): Boolean {
        println("Sent to payment")
        return true
    }
}