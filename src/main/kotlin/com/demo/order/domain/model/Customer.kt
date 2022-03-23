package com.demo.order.domain.model

import java.util.UUID

data class Customer(
    val id: UUID? = UUID.randomUUID(),
    val cpf: String,
    val name: String,
    val cards: List<Card>? = mutableListOf()
)