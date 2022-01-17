package com.tul.shoppingcart.dto

import java.math.BigDecimal

class ProductDTO(
    val name: String?,
    val sku: String?,
    val description: String?,
    val price: BigDecimal?,
    val hasDiscount: Boolean = false
)