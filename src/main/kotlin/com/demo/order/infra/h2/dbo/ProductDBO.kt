package com.demo.order.infra.h2.dbo

import com.demo.order.domain.model.Product
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ProductDBO(
    @Id
    val id: String,
    val code: String,
    val name: String,
    val value: Long
) {
    fun toModel() = Product(
        id = UUID.fromString(this.id),
        code = this.code,
        name = this.name,
        value = this.value
    )
}

fun Product.toDBO() = ProductDBO(
    id = this.id.toString(),
    code = this.code,
    name = this.name,
    value = this.value
)
