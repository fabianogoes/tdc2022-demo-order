package com.demo.order.domain.port

import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer

interface CreditCardDataAccessPort {
    fun findCardByCustomer(customer: Customer): Card?
}