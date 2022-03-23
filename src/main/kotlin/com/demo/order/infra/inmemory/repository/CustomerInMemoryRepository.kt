package com.demo.order.infra.inmemory.repository

import com.demo.order.domain.model.Customer

const val CPF = "84917644020"

val CUSTOMER = Customer(
    name = MASTERCARD_NAME,
    cpf = CPF,
    cards = CARDS
)

val CUSTOMERS = listOf(CUSTOMER)

