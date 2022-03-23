package com.demo.order.infra.h2.repository

import com.demo.order.infra.h2.dbo.CustomerDBO
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerDBO, String> {
    fun findByCpf(cpf: String): CustomerDBO?
}