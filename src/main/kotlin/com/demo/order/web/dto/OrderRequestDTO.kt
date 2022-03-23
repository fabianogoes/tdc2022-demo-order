package com.demo.order.web.dto

import com.demo.order.domain.model.Order
import java.util.UUID

class OrderRequestDTO(
    val cpf: String,
    val productCodes: List<String>
)

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
