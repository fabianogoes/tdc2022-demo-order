package com.demo.order.infra.repository.memory

import com.demo.order.domain.model.Product
import com.demo.order.domain.port.IProductRepository
import org.springframework.stereotype.Repository

const val PRODUCT_EAN_7895824271025 = "7895824271025"
const val PRODUCT_NAME_MAC = "Macbook Pro M1"
const val PRODUCT_EAN_7898242582360 = "7898242582360"
const val PRODUCT_NAME_IPHONE = "iPhone 13 Pro"

val PRODUCT_7895824271025 = Product(
    code = PRODUCT_EAN_7895824271025,
    name = PRODUCT_NAME_MAC,
    value = 21500_50
)

val PRODUCT_7898242582360 = Product(
    code = PRODUCT_EAN_7898242582360,
    name = PRODUCT_NAME_IPHONE,
    value = 10000_00
)

val PRODUCTS = listOf(
    PRODUCT_7895824271025,
    PRODUCT_7898242582360
)

@Repository
class ProductMemoryRepository : IProductRepository {
    override fun findByCodes(products: List<String>): List<Product>? =
        PRODUCTS
}