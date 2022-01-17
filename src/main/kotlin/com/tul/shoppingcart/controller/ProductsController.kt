package com.tul.shoppingcart.controller

import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.repository.model.Product
import com.tul.shoppingcart.services.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/product"])
class ProductsController(
    val productService: ProductService
) {

    @GetMapping("/all")
    fun getProducts(): MutableIterable<Product> {
        return productService.getAllProducts()
    }

    @PostMapping("/")
    fun addProduct(@RequestBody request: ProductDTO): String {
        return ""
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