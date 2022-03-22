package com.demo.order.infra.h2.dbo

import com.demo.order.domain.model.Order
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
data class OrderDBO(
    @Id
    val id: String,

    @OneToOne
    val customer: CustomerDBO,

    @OneToMany
    val products: List<ProductDBO>,

    @OneToOne
    val payment: CardDBO,

    var state: String
) {
    fun toModel() = Order(
        id = UUID.fromString(this.id),
        customer = this.customer.toModel(),
        products = this.products.map { it.toModel() },
        payment = this.payment.toModel(),
        state = enumValueOf(this.state)
    )
}

fun Order.toDBO() = OrderDBO(
    id = this.id.toString(),
    customer = this.customer.toDBO(),
    products = this.products.map { it.toDBO() },
    payment = this.payment.toDBO(),
    state = this.state.name
)