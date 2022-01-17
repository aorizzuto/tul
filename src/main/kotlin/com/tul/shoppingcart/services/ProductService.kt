package com.tul.shoppingcart.services

import com.tul.shoppingcart.converters.RequestConverter
import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.repository.ProductRepository
import com.tul.shoppingcart.repository.model.Product
import com.tul.shoppingcart.validations.RequestValidator
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository
) {

    fun getAllProducts(): MutableIterable<Product> {
        return productRepository.findAll()
    }

    fun saveProduct(request: ProductDTO): String {
        RequestValidator.validateProductToSave(request)
        return productRepository.save(RequestConverter.convert(request)).id.toString()
    }
}