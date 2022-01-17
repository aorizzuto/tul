package com.tul.shoppingcart.services

import com.tul.shoppingcart.converters.RequestConverter
import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.exceptions.BadRequestException
import com.tul.shoppingcart.exceptions.ErrorCode
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
        RequestValidator.validateId(id)
        return try{
            productRepository.deleteById(UUID.fromString(id))
            "Product with ID $id was removed successfully"
        } catch (exc: Exception) {
            throw BadRequestException(ErrorCode.PRODUCT_NOT_FOUND)
        }
    }

    fun updateProduct(id: String?, request: ProductDTO): Product {
        RequestValidator.validateUpdateRequest(id, request)
        val optionalProduct = productRepository.findById(UUID.fromString(id))

        if (optionalProduct.isEmpty) throw BadRequestException(ErrorCode.PRODUCT_NOT_FOUND)

        val product = optionalProduct.get()

        product.description = request.description ?: product.description
        product.name = request.name ?: product.name
        product.price = request.price ?: product.price
        product.sku = request.sku ?: product.sku
        product.hasDiscount = request.hasDiscount ?: product.hasDiscount

        return productRepository.save(product)
    }
}