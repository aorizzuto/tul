package com.tul.shoppingcart.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

class ProductDTO(
    val name: String?,
    val sku: String?,
    val description: String?,
    val price: BigDecimal?,
    @JsonProperty("has_discount")
    val hasDiscount: Boolean? = false
)