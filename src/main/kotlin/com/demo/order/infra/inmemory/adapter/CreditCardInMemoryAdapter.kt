package com.demo.order.infra.inmemory.adapter

import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer
import com.demo.order.domain.port.CreditCardDataAccessPort
import com.demo.order.domain.port.CustomerDataAccessPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class CreditCardInMemoryAdapter : CreditCardDataAccessPort {

    @Autowired
    private lateinit var customerRepository: CustomerDataAccessPort

    override fun findCardByCustomer(customer: Customer): Card? =
        customerRepository
            .findByCpf(customer.cpf)?.cards
            ?.first { it.main }

}