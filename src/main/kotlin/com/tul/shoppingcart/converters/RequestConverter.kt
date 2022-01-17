package com.tul.shoppingcart.converters

import com.tul.shoppingcart.dto.ProductDTO
import com.tul.shoppingcart.repository.model.Product

object RequestConverter {

    fun convert(request: ProductDTO) = Product(
        name = request.name!!,
        sku = request.sku!!,
        description = request.description!!,
        price = request.price!!,
        hasDiscount = request.hasDiscount ?: false
    )
}