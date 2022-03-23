package com.demo.order.infra.inmemory.adapter

import com.demo.order.domain.model.Customer
import com.demo.order.domain.port.CustomerDataAccessPort
import com.demo.order.infra.inmemory.repository.CUSTOMERS
import org.springframework.stereotype.Repository

@Repository
class CustomerInMemoryAdapter : CustomerDataAccessPort {
    override fun findByCpf(cpf: String): Customer? =
        CUSTOMERS.first { it.cpf == cpf }
}