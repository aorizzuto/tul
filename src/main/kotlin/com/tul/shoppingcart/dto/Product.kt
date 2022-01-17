package com.tul.shoppingcart.dto

import java.math.BigDecimal

class Product(
    val name: String,
    val sku: String,
    val description: String,
    val price: BigDecimal,
    val hasDiscount: Boolean
)