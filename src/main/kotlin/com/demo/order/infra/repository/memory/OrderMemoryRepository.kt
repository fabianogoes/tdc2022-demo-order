package com.demo.order.infra.repository.memory

import com.demo.order.domain.model.Order
import com.demo.order.domain.port.IOrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderMemoryRepository : IOrderRepository {
    override fun save(order: Order): Order =
        ORDERS
            .add(order)
            .let { order }

    companion object {
        val ORDERS = mutableListOf<Order>()
    }
}

