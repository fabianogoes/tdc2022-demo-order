package com.demo.order.infra.h2.adapter

import com.demo.order.domain.model.Order
import com.demo.order.domain.port.OrderDataAccessPort
import com.demo.order.infra.h2.dbo.toDBO
import com.demo.order.infra.h2.repository.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderH2Adapter(
    private val repository: OrderRepository
) : OrderDataAccessPort {
    override fun save(order: Order): Order = repository.save(order.toDBO()).toModel()
}