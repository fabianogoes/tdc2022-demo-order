package com.demo.order.domain.port

import com.demo.order.domain.model.Order

interface OrderDataAccessPort {
    fun save(order: Order): Order
}