package com.tul.shoppingcart.services

import com.tul.shoppingcart.repository.ProductRepository
import com.tul.shoppingcart.repository.model.Product
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository
) {

    fun getAllProducts(): MutableIterable<Product> {
        return productRepository.findAll()
    }
}