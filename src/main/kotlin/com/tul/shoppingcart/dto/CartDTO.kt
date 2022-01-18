package com.tul.shoppingcart.dto

import com.tul.shoppingcart.enums.StatusEnum
import com.tul.shoppingcart.repository.model.Order

class CartDTO (
    val orders: MutableList<Order>,
    val status: StatusEnum
)