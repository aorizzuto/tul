package com.tul.shoppingcart.services

import com.tul.shoppingcart.converters.RequestConverter
import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.repository.ProductRepository
import com.tul.shoppingcart.repository.model.Product
import com.tul.shoppingcart.validations.RequestValidator
import org.springframework.stereotype.Service
import java.util.*

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

    fun deleteProduct(id: String?): String {
        RequestValidator.validateField(id)
        return try{
            productRepository.deleteById(UUID.fromString(id))
            "Product with ID $id was removed successfully"
        } catch (exc: Exception) {
            "No product was found with ID $id"
        }
    }
}