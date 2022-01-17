package com.tul.shoppingcart.controller

import com.tul.shoppingcart.dto.Product
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/cart"])
class ShoppingCartController {

    @GetMapping("/all")
    fun getProducts(): MutableList<String> {
        return mutableListOf("product1", "product2")
    }

    @PostMapping("/")
    fun addProduct(@RequestBody request: Product): String {
        return ""
    }

    @DeleteMapping("/{name}")
    fun removeProduct(@PathVariable name: String): String {
        return ""
    }

    @PutMapping("/")
    fun updateProduct(@RequestBody request: Product): String {
        return ""
    }
}