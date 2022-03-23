package com.demo.order.web.controller

import com.demo.order.domain.usecase.FinalizeOrderUseCase
import com.demo.order.web.dto.OrderRequestDTO
import com.demo.order.web.dto.OrderResponseDTO
import com.demo.order.web.dto.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("order")
class OrderController {

    @Autowired
    private lateinit var finalizeOrderUseCase: FinalizeOrderUseCase

    @PostMapping
    fun create(@RequestBody dto: OrderRequestDTO): ResponseEntity<OrderResponseDTO> {
        val order = finalizeOrderUseCase.finalize(dto.cpf, dto.productCodes)
        return ResponseEntity.ok(order.toResponse())
    }

}