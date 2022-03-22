package com.demo.order.domain.model

import java.time.YearMonth
import java.util.UUID

data class Customer(
    val cpf: String,
    val name: String,
    val cards: List<Card>
)

data class Product(
    val code: String,
    val name: String,
    val value: Long
)

data class Card(
    val issuer: IssuerType,
    val number: String,
    val expiry: YearMonth,
    val cvv: Int,
    val displayName: String,
    val main: Boolean = true
) {
    enum class IssuerType {
        VISA, MASTERCARD,
    }
}

data class Order(
    val id: UUID? = UUID.randomUUID(),
    val customer: Customer,
    val products: List<Product>,
    val payment: Card,
    var state: OrderState,
) {
    fun completed() = apply { state = OrderState.COMPLETED }
    fun total() = products.sumOf { it.value }

    enum class OrderState {
        CREATED,
        COMPLETED
    }
}