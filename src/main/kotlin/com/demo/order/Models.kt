package com.demo.order

import java.time.YearMonth

data class Customer(
    val cpf: String,
    val name: String,
    val cards: List<Card>
)

data class Product(
    val code: String,
    val name: String
)

data class Card(
    val issuer: IssuerType,
    val number: String,
    val expiry: YearMonth,
    val cvv: Int,
    val displayName: String,
    val main: Boolean = true
) {
    enum class IssuerType {
        VISA, MASTERCARD,
    }
}

data class Order(
    val customer: Customer,
    val products: List<Product>,
    val card: Card
)