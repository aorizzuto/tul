package com.tul.shoppingcart.validations

import com.tul.shoppingcart.dto.OrderDTO
import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.exceptions.BadRequestException
import com.tul.shoppingcart.exceptions.ErrorCode.*
import java.util.*
import java.util.stream.Stream

object OrderValidator {

    fun validate(order: OrderDTO) {
        order.productId ?: throw BadRequestException(ID_NOT_FOUND)
        order.quantity ?: throw BadRequestException(QUANTITY_NOT_FOUND)
        if (order.quantity <= 0) throw BadRequestException(QUANTITY_INCORRECT)
    }
}