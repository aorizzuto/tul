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

    @PostMapping("/", produces = ["application/json; charset=utf-8"])
    fun addProduct(@RequestBody request: ProductDTO): String {
        return productService.saveProduct(request)
    }

    @DeleteMapping("/{id}")
    fun removeProduct(@PathVariable id: String?): String {
        return productService.deleteProduct(id)
    }

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: String,
        @RequestBody request: ProductDTO
    ): Product {
        return productService.updateProduct(id, request)
    }
}