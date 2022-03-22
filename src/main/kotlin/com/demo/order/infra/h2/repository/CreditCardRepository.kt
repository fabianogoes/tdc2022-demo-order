package com.demo.order.infra.h2.repository

import com.demo.order.infra.h2.dbo.CardDBO
import org.springframework.data.jpa.repository.JpaRepository

interface CreditCardRepository : JpaRepository<CardDBO, String> {
    fun findByCustomerCpf(cpf: String): List<CardDBO>
}