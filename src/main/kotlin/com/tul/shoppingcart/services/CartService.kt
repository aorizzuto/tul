package com.tul.shoppingcart.services

import com.tul.shoppingcart.dto.CashoutDTO
import com.tul.shoppingcart.dto.OrderDTO
import com.tul.shoppingcart.enums.StatusEnum
import com.tul.shoppingcart.exceptions.BadRequestException
import com.tul.shoppingcart.exceptions.ErrorCode
import com.tul.shoppingcart.repository.CartRepository
import com.tul.shoppingcart.repository.OrderRepository
import com.tul.shoppingcart.repository.ProductRepository
import com.tul.shoppingcart.repository.model.Cart
import com.tul.shoppingcart.repository.model.Order
import com.tul.shoppingcart.validations.OrderValidator
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class CartService(
    val orderRepository: OrderRepository,
    val productRepository: ProductRepository,
    val cartRepository: CartRepository
) {

    fun addProduct(orderDTO: OrderDTO): String {
        OrderValidator.validate(orderDTO)

        val actualCart = findActualCart()

        return try{
            val order = saveOrder(orderDTO)
            saveOrderInCart(order, actualCart)

            "Product with ID: ${orderDTO.productId} has been added successfully"
        } catch (exc: Exception) {
            "Product present errors and has not been added."
        }
    }

    private fun saveOrder(orderDTO: OrderDTO): Order {
        val product = productRepository.findById(orderDTO.productId!!).get()
        val order = Order(product = product, quantity = orderDTO.quantity!!)
        orderRepository.save(order)
        return order
    }

    private fun saveOrderInCart(order: Order, actualCart: Cart) {
        actualCart.orders.add(order)
        cartRepository.save(actualCart)
    }

    private fun findActualCart(): Cart {
        return try {
            cartRepository.findByStatus(StatusEnum.PENDING.value)
        } catch (exc: Exception) {
            cartRepository.save(Cart())
        }
    }

    fun cashout(): CashoutDTO {
        var total = BigDecimal.ZERO
        val map = mutableMapOf<UUID, Int>()

        val actualCart = findActualCart()

        actualCart.orders.forEach { order ->
            val finalPrice = if (order.product.hasDiscount) order.product.price.divide(BigDecimal(2)) else order.product.price

            total += finalPrice.multiply(BigDecimal(order.quantity))
            map[order.product.id] = order.quantity
        }

        updateStatusInCart(actualCart)

        return CashoutDTO(map, total)
    }

    private fun updateStatusInCart(actualCart: Cart) {
        actualCart.status = StatusEnum.COMPLETED.value
        cartRepository.save(actualCart)
    }
}