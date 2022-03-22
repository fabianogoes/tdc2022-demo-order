package com.demo.order.domain.port

import com.demo.order.domain.model.Card
import com.demo.order.domain.model.Customer
import com.demo.order.domain.model.Order
import com.demo.order.domain.model.Product

interface ICustomerRepository {
    fun findByCpf(cpf: String): Customer?
}

interface ICreditCardRepository {
    fun findCardByCustomer(customer: Customer): Card?
}

interface IProductRepository {
    fun findByCodes(products: List<String>): List<Product>?
}

interface IOrderRepository {
    fun save(order: Order): Order
}