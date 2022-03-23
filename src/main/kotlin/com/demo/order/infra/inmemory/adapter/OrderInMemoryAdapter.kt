package com.demo.order.infra.inmemory.adapter

import com.demo.order.domain.model.Order
import com.demo.order.domain.port.OrderDataAccessPort
import com.demo.order.infra.inmemory.repository.ORDERS
import org.springframework.stereotype.Repository

@Repository
class OrderInMemoryAdapter : OrderDataAccessPort {
    override fun save(order: Order): Order =
        ORDERS
            .add(order)
            .let { order }
}

