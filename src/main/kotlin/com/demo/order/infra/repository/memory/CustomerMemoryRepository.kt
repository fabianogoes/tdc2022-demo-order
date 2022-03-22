package com.demo.order.infra.repository.memory

import com.demo.order.domain.model.Customer
import com.demo.order.domain.port.ICustomerRepository
import org.springframework.stereotype.Repository

const val CPF = "84917644020"

val CUSTOMER = Customer(
    name = MASTERCARD_NAME,
    cpf = CPF,
    cards = CARDS
)

val CUSTOMERS = listOf(CUSTOMER)

@Repository
class CustomerMemoryRepository : ICustomerRepository {
    override fun findByCpf(cpf: String): Customer? =
        CUSTOMERS.first { it.cpf == cpf }
}