package com.tul.shoppingcart.dto

import com.tul.shoppingcart.enums.StatusEnum

class CartDTO (
    val products: HashMap<ProductDTO, Int>,
    val status: StatusEnum
)