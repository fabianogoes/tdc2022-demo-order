package com.demo.order.infra.repository.memory

import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer
import com.demo.order.domain.port.ICreditCardRepository
import com.demo.order.domain.port.ICustomerRepository
import org.springframework.beans.factory.annotation.Autowired
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

@Repository
class CreditCardMemoryRepository : ICreditCardRepository {

    @Autowired private lateinit var customerRepository: ICustomerRepository

    override fun findCardByCustomer(customer: Customer): Card? =
        customerRepository
            .findByCpf(customer.cpf)?.cards
            ?.first { it.main }

}