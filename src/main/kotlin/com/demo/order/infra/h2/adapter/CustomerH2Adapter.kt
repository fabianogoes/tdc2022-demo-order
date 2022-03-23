package com.demo.order.infra.h2.adapter

import com.demo.order.domain.exception.CustomerNotFoundException
import com.demo.order.domain.model.Customer
import com.demo.order.domain.port.CustomerDataAccessPort
import com.demo.order.infra.h2.dbo.toDBO
import com.demo.order.infra.h2.repository.CustomerRepository
import org.springframework.stereotype.Repository

@Repository
class CustomerH2Adapter(
    private val repository: CustomerRepository
) : CustomerDataAccessPort {
    override fun findByCpf(cpf: String): Customer? =
        repository.findByCpf(cpf)?.toModel() ?: throw CustomerNotFoundException()

    override fun save(customer: Customer): Customer =
        repository.save(customer.toDBO()).toModel()
}