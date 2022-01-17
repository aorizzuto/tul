package com.tul.shoppingcart.validations

import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.exceptions.BadRequestException
import com.tul.shoppingcart.exceptions.ErrorCode.*
import java.util.*
import java.util.stream.Stream

object RequestValidator {

    fun validateProductToSave(request: ProductDTO) {
        request.description ?: throw BadRequestException(DESCRIPTION_NOT_FOUND)
        request.name ?: throw BadRequestException(NAME_NOT_FOUND)
        request.price ?: throw BadRequestException(PRICE_NOT_FOUND)
        request.sku ?: throw BadRequestException(SKU_NOT_FOUND)
    }

    fun validateId(id: String?) {
        id ?: throw BadRequestException(ID_NOT_FOUND)
    }

    fun validateUpdateRequest(id: String?, request: ProductDTO?) {
        validateId(id)
        Stream.of(request!!.description, request.sku, request.name, request.price, request.hasDiscount)
            .allMatch(Objects::isNull).let { result ->
                if (result) throw BadRequestException(NOT_NULL_EXPECTED)
            }
    }
}