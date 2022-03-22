package com.demo.order.domain.model

import java.time.YearMonth
import java.util.*

data class Card(
    val id: UUID? = UUID.randomUUID(),
    val issuer: IssuerType,
    val number: String,
    val expiry: YearMonth,
    val cvv: Int,
    val displayName: String,
    val main: Boolean = true,
    val customer: Customer
) {
    enum class IssuerType {
        VISA, MASTERCARD,
    }
}