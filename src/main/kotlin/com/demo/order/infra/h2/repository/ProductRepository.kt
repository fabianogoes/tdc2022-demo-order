package com.demo.order.infra.h2.repository

import com.demo.order.infra.h2.dbo.ProductDBO
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductDBO, String>