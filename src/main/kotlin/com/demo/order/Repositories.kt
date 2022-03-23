package com.demo.order

import org.springframework.stereotype.Repository
import java.time.YearMonth

const val MASTERCARD_NAME = "Zack Wyman"
const val MASTERCARD_NUMBER = "5378122399914634"
const val VISA_NUMBER = "4916490416648119"
const val VISA_NAME = "Clare Parisian"

val MASTER_CARD = Card(
    issuer = Card.IssuerType.MASTERCARD,
    number = MASTERCARD_NUMBER,
    expiry = YearMonth.of(2022, 4),
    cvv = 597,
    displayName = MASTERCARD_NAME.uppercase(),
    main = true
)

val VISA_CARD = Card(
    issuer = Card.IssuerType.VISA,
    number = VISA_NUMBER,
    expiry = YearMonth.of(2025, 2),
    cvv = 900,
    displayName = VISA_NAME.uppercase(),
    main = false
)

val CARDS = listOf(
    MASTER_CARD,
    VISA_CARD
)

const val CPF = "84917644020"

val CUSTOMER = Customer(
    name = MASTERCARD_NAME,
    cpf = CPF,
    cards = CARDS
)

val CUSTOMERS = listOf(CUSTOMER)

const val PRODUCT_EAN_7895824271025 = "7895824271025"
const val PRODUCT_NAME_7895824271025 = "Macbook Pro M1"
const val PRODUCT_EAN_7898242582360 = "7898242582360"
const val PRODUCT_NAME_7898242582360 = "iPhone 13 Pro"

val PRODUCT_7895824271025 = Product(
    code = PRODUCT_EAN_7895824271025,
    name = PRODUCT_NAME_7895824271025
)

val PRODUCT_7898242582360 = Product(
    code = PRODUCT_EAN_7898242582360,
    name = PRODUCT_NAME_7898242582360
)

val PRODUCTS = listOf(
    PRODUCT_7895824271025,
    PRODUCT_7898242582360
)

class CustomerRepository {
    fun findByCpf(cpf: String): Customer =
        CUSTOMERS.first { it.cpf == cpf }
}

class CreditCardRepository {

    fun findCardByCustomer(customer: Customer): Card =
        CUSTOMERS
            .first { it.cpf == customer.cpf }.cards
            .first { it.main }

}

@Repository
class ProductRepository {

    fun findByCodes(products: List<String>): List<Product> =
        PRODUCTS

}

val ORDERS = mutableListOf<Order>()

class OrderRepository {

    fun finalizeOrder(order: Order): Order =
        ORDERS
            .add(order)
            .let { order }

}