package com.demo.order.domain.model

import java.util.UUID

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