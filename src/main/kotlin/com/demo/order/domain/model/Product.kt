package com.demo.order.domain.model

import java.util.*

data class Product(
    val id: UUID? = UUID.randomUUID(),
    val code: String,
    val name: String,
    val value: Long
)