package com.tul.shoppingcart.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class OrderDTO (
    @JsonProperty("product_id")
    val productId: UUID?,
    val quantity: Int?
)