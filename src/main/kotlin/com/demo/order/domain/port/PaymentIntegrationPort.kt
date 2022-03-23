package com.demo.order.domain.port

interface PaymentIntegrationPort {
    fun pay(cardNumber: String, value: Long): Boolean
}