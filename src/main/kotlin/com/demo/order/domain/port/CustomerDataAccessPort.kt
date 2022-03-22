package com.demo.order.domain.port

import com.demo.order.domain.model.Customer

interface CustomerDataAccessPort {
    fun findByCpf(cpf: String): Customer?
    fun save(customer: Customer): Customer
}