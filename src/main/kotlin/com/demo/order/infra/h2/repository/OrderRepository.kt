package com.demo.order.infra.h2.repository

import com.demo.order.infra.h2.dbo.OrderDBO
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderDBO, String>