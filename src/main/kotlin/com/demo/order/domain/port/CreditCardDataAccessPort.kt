package com.demo.order.domain.port

import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer
import com.demo.order.infra.h2.dbo.CardDBO

interface CreditCardDataAccessPort {
    fun findCardByCustomer(customer: Customer): Card?
    fun save(card: Card): Card
}