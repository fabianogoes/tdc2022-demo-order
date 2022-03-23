package com.demo.order.domain.usecase

import com.demo.order.domain.exception.CustomerNotFoundException
import com.demo.order.domain.exception.FinalizeOrderException
import com.demo.order.domain.exception.PaymentFailureException
import com.demo.order.domain.exception.PaymentNotFoundException
import com.demo.order.domain.exception.ProductNotFoundException
import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer
import com.demo.order.domain.model.Order
import com.demo.order.domain.model.Product
import com.demo.order.domain.port.CreditCardDataAccessPort
import com.demo.order.domain.port.CustomerDataAccessPort
import com.demo.order.domain.port.OrderDataAccessPort
import com.demo.order.domain.port.PaymentIntegrationPort
import com.demo.order.domain.port.ProductDataAccessPort
import org.springframework.stereotype.Service

@Service
class FinalizeOrderUseCase(
    private val customerDataAccess: CustomerDataAccessPort,
    private val productDataAccess: ProductDataAccessPort,
    private val creditCardDataAccess: CreditCardDataAccessPort,
    private val orderDataAccess: OrderDataAccessPort,
    private val paymentIntegration: PaymentIntegrationPort
) {
    fun finalize(customerCpf: String, productCodes: List<String>): Order {
        try {
            val products = productDataAccess.findByCodes(productCodes) ?: throw ProductNotFoundException()
            val customer = customerDataAccess.findByCpf(customerCpf) ?: throw CustomerNotFoundException()
            val creditCard = creditCardDataAccess.findCardByCustomer(customer) ?: throw PaymentNotFoundException()

            val order = create(customer, products, creditCard)

            return payment(creditCard, order)
        } catch (ex: Exception) {
            throw FinalizeOrderException()
        }
    }

    private fun payment(creditCard: Card, order: Order): Order {
        val paid = paymentIntegration.pay(creditCard.number, order.total())
        if (!paid) {
            throw PaymentFailureException()
        }

        order.completed()
        return orderDataAccess.save(order)
    }

    private fun create(customer: Customer, products: List<Product>, creditCard: Card): Order {
        val order = Order(
            customer = customer,
            products = products,
            payment = creditCard,
            state = Order.OrderState.CREATED
        )
        orderDataAccess.save(order)
        return order
    }
}

