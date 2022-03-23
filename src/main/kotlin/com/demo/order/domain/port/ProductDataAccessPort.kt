package com.demo.order.domain.port

import com.demo.order.domain.model.Product

interface ProductDataAccessPort {
    fun findByCodes(products: List<String>): List<Product>?
    fun save(product: Product): Product
}