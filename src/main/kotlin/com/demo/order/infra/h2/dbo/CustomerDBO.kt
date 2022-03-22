package com.demo.order.infra.h2.dbo

import com.demo.order.domain.model.Customer
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CustomerDBO(
    @Id
    val id: String,
    val cpf: String,
    val name: String,
) {
    fun toModel() = Customer(
        id = UUID.fromString(this.id),
        cpf = this.cpf,
        name = this.name
    )
}

fun Customer.toDBO() = CustomerDBO(
    id = this.id.toString(),
    cpf = this.cpf,
    name = this.name
)