package com.tul.shoppingcart.controller

import com.tul.shoppingcart.dto.CashoutDTO
import com.tul.shoppingcart.dto.OrderDTO
import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.services.CartService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/cart"])
class ShoppingCartController(
    val cartService: CartService
) {

    @GetMapping("/all")
    fun getProducts(): List<List<Any>> {
        return cartService.getProducts()
    }

    @GetMapping("/cashout")
    fun cashout(): CashoutDTO {
        return cartService.cashout()
    }

    @PostMapping("/")
    fun addProduct(@RequestBody order: OrderDTO): String {
        return cartService.addProduct(order)
    }

    @DeleteMapping("/{id}")
    fun removeProduct(@PathVariable id: String): String {
        return cartService.removeProduct(id)
    }
}