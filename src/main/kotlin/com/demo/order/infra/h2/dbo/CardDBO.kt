package com.demo.order.infra.h2.dbo

import com.demo.order.domain.model.Card
import java.time.YearMonth
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class CardDBO(
    @Id
    val id: String,
    val issuer: String,
    val number: String,
    val expiry: YearMonth,
    val cvv: Int,
    val displayName: String,
    val main: Boolean = true,

    @ManyToOne
    val customer: CustomerDBO
) {
    fun toModel() = Card(
        id = UUID.fromString(this.id),
        issuer = enumValueOf(this.issuer),
        number = this.number,
        expiry = this.expiry,
        cvv = this.cvv,
        displayName = this.displayName,
        main = this.main,
        customer = this.customer.toModel()
    )
}

fun Card.toDBO() = CardDBO(
    id = this.id.toString(),
    issuer = this.issuer.name,
    number = this.number,
    expiry = this.expiry,
    cvv = this.cvv,
    displayName = this.displayName,
    main = this.main,
    customer = this.customer.toDBO()
)