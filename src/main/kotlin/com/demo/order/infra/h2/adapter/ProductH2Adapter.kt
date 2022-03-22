package com.demo.order.infra.h2.adapter

import com.demo.order.domain.model.Product
import com.demo.order.domain.port.ProductDataAccessPort
import com.demo.order.infra.h2.dbo.toDBO
import com.demo.order.infra.h2.repository.ProductRepository
import org.springframework.stereotype.Repository

@Repository
class ProductH2DataAccessPort(
    private val repository: ProductRepository
) : ProductDataAccessPort {
    override fun findByCodes(products: List<String>): List<Product>? =
        repository.findAll().map { it.toModel() }

    override fun save(product: Product): Product =
        repository.save(product.toDBO()).toModel()
}