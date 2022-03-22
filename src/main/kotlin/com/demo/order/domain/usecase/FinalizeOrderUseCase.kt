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
import com.demo.order.domain.port.ICreditCardRepository
import com.demo.order.domain.port.ICustomerRepository
import com.demo.order.domain.port.IOrderRepository
import com.demo.order.infra.integration.IPaymentIntegration
import com.demo.order.domain.port.IProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FinalizeOrderUseCase {

    @Autowired private lateinit var customerRepository: ICustomerRepository
    @Autowired private lateinit var productRepository: IProductRepository
    @Autowired private lateinit var creditCardRepository: ICreditCardRepository
    @Autowired private lateinit var orderRepository: IOrderRepository
    @Autowired private lateinit var paymentIntegration: IPaymentIntegration

    fun finalize(customerCpf: String, productCodes: List<String>): Order {
        try {
            val products = productRepository.findByCodes(productCodes) ?: throw ProductNotFoundException()
            val customer = customerRepository.findByCpf(customerCpf) ?: throw CustomerNotFoundException()
            val creditCard = creditCardRepository.findCardByCustomer(customer) ?: throw PaymentNotFoundException()

            val order = create(customer, products, creditCard)

            return payment(creditCard, order)
        } catch (ex: Exception) {
            throw FinalizeOrderException()
        }
    }

    private fun payment(
        creditCard: Card,
        order: Order
    ): Order {
        val paid = paymentIntegration.pay(creditCard.number, order.total())
        if (!paid) {
            throw PaymentFailureException()
        }

        order.completed()
        return orderRepository.save(order)
    }

    private fun create(
        customer: Customer,
        products: List<Product>,
        creditCard: Card
    ): Order {
        val order = Order(
            customer = customer,
            products = products,
            payment = creditCard,
            state = Order.OrderState.CREATED
        )
        orderRepository.save(order)
        return order
    }
}
