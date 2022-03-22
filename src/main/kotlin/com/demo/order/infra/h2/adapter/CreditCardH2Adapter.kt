package com.demo.order.infra.h2.adapter

import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer
import com.demo.order.domain.port.CreditCardDataAccessPort
import com.demo.order.infra.h2.dbo.toDBO
import com.demo.order.infra.h2.repository.CreditCardRepository
import org.springframework.stereotype.Repository

@Repository
class CreditCardH2Adapter(
    private val repository: CreditCardRepository
) : CreditCardDataAccessPort {
    override fun findCardByCustomer(customer: Customer): Card? =
        repository
            .findByCustomerCpf(customer.cpf)
            .first { it.main }
            .toModel()

    override fun save(card: Card): Card =
        repository.save(card.toDBO()).toModel()
}