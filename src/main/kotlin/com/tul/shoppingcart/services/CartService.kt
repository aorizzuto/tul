package com.tul.shoppingcart.services

import com.tul.shoppingcart.dto.CashoutDTO
import com.tul.shoppingcart.dto.OrderDTO
import com.tul.shoppingcart.exceptions.BadRequestException
import com.tul.shoppingcart.exceptions.ErrorCode
import com.tul.shoppingcart.repository.OrderRepository
import com.tul.shoppingcart.repository.ProductRepository
import com.tul.shoppingcart.repository.model.Order
import com.tul.shoppingcart.validations.OrderValidator
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class CartService(
    val orderRepository: OrderRepository,
    val productRepository: ProductRepository
) {

    fun addProduct(orderDTO: OrderDTO): String {
        OrderValidator.validate(orderDTO)

        return try{
            val optionalProduct = productRepository.findById(orderDTO.productId!!)
            val product = optionalProduct.get()
            val order = Order(product = product, quantity = orderDTO.quantity!!)
            orderRepository.save(order)

            "Product with ID: ${orderDTO.productId} has been added successfully"
        } catch (exc: Exception) {
            "Product present errors and has not been added."
        }
    }

    fun cashout(): CashoutDTO {
        var total = BigDecimal.ZERO
        val map = mutableMapOf<UUID, Int>()
        orderRepository.findAll().forEach { order ->
            val finalPrice = if (order.product.hasDiscount) order.product.price.divide(BigDecimal(2)) else order.product.price

            total += finalPrice.multiply(BigDecimal(order.quantity))
            map[order.product.id] = order.quantity
        }

        return CashoutDTO(map, total)
    }
}