package com.demo.order.infra.inmemory.adapter

import com.demo.order.domain.model.Product
import com.demo.order.domain.port.ProductDataAccessPort
import com.demo.order.infra.inmemory.repository.PRODUCTS
import org.springframework.stereotype.Repository

@Repository
class ProductInMemoryAdapter : ProductDataAccessPort {
    override fun findByCodes(products: List<String>): List<Product>? = PRODUCTS
}