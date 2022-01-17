package com.tul.shoppingcart.validations

import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.exceptions.BadRequestException
import com.tul.shoppingcart.exceptions.ErrorCode.*

object RequestValidator {

    fun validateProductToSave(request: ProductDTO) {
        request.description ?: throw BadRequestException(DESCRIPTION_NOT_FOUND)
        request.name ?: throw BadRequestException(NAME_NOT_FOUND)
        request.price ?: throw BadRequestException(PRICE_NOT_FOUND)
        request.sku ?: throw BadRequestException(SKU_NOT_FOUND)
    }
}