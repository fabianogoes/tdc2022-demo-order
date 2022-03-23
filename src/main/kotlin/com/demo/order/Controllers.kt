package com.demo.order

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("orders")
class Controllers {

    @PostMapping
    fun post(@RequestBody dto: OrderDTO): ResponseEntity<Order> {
        val customerRepository = CustomerRepository()
        val customer = customerRepository.findByCpf(dto.cpf)

        val productRepository = ProductRepository()
        val listOfProducts = productRepository.findByCodes(dto.productCodes)

        val creditCardRepository = CreditCardRepository()
        val card = creditCardRepository.findCardByCustomer(customer)

        val order = Order(customer, listOfProducts, card)
        val orderRepository = OrderRepository()
        val orderSaved = orderRepository.finalizeOrder(order)

        return ResponseEntity.ok(orderSaved)
    }

}