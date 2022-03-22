package com.demo.order.infra.h2

import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer
import com.demo.order.domain.model.Product
import com.demo.order.domain.port.CreditCardDataAccessPort
import com.demo.order.domain.port.CustomerDataAccessPort
import com.demo.order.domain.port.ProductDataAccessPort
import com.demo.order.infra.h2.dbo.toDBO
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.YearMonth
import java.util.UUID

const val CPF = "84917644020"
const val MASTERCARD_NAME = "Zack Wyman"
const val MASTERCARD_NUMBER = "5378122399914634"
const val VISA_NUMBER = "4916490416648119"
const val VISA_NAME = "Clare Parisian"
const val PRODUCT_EAN_7895824271025 = "7895824271025"
const val PRODUCT_NAME_MAC = "Macbook Pro M1"
const val PRODUCT_EAN_7898242582360 = "7898242582360"
const val PRODUCT_NAME_IPHONE = "iPhone 13 Pro"

@Component
class JpaDataLoader(
    private val productRepository: ProductDataAccessPort,
    private val customerRepository: CustomerDataAccessPort,
    private val creditCardRepository: CreditCardDataAccessPort
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        Product(
            code = PRODUCT_EAN_7895824271025,
            name = PRODUCT_NAME_MAC,
            value = 21500_50
        ).run { productRepository.save(this) }
        Product(
            code = PRODUCT_EAN_7898242582360,
            name = PRODUCT_NAME_IPHONE,
            value = 10000_00
        ).run { productRepository.save(this) }

        customerRepository.save(Customer(name = MASTERCARD_NAME, cpf = CPF)).let { customer ->
            Card(
                id = UUID.randomUUID(),
                issuer = Card.IssuerType.MASTERCARD,
                number = MASTERCARD_NUMBER,
                expiry = YearMonth.of(2022, 4),
                cvv = 597,
                displayName = MASTERCARD_NAME.uppercase(),
                main = true,
                customer = customer
            ).run { creditCardRepository.save(this) }
            Card(
                id = UUID.randomUUID(),
                issuer = Card.IssuerType.VISA,
                number = VISA_NUMBER,
                expiry = YearMonth.of(2025, 2),
                cvv = 900,
                displayName = VISA_NAME.uppercase(),
                main = false,
                customer = customer
            ).run { creditCardRepository.save(this) }
        }
    }
}