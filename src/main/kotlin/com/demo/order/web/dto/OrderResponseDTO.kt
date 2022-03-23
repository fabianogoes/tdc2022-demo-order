package com.demo.order.web.dto

import com.demo.order.domain.model.Order
import java.util.*

class OrderResponseDTO(
    val id: UUID,
    val state: OrderStateDTO
) {
    enum class OrderStateDTO {
        CREATED,
        REQUEST_PAYMENT,
        COMPLETED
    }
}

fun Order.toResponse() =
    OrderResponseDTO(
        id = this.id!!,
        state = enumValueOf(this.state.name)
    )