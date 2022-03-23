package com.demo.order.infra.inmemory.repository

import com.demo.order.domain.model.Product

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

