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
    fun getProducts(): MutableList<String> {
        return mutableListOf("product1", "product2")
    }

    @GetMapping("/cashout")
    fun cashout(): CashoutDTO {
        return cartService.cashout()
    }

    @PostMapping("/")
    fun addProduct(@RequestBody order: OrderDTO): String {
        return cartService.addProduct(order)
    }

    @DeleteMapping("/{name}")
    fun removeProduct(@PathVariable name: String): String {
        return ""
    }

    @PutMapping("/")
    fun updateProduct(@RequestBody request: ProductDTO): String {
        return ""
    }
}