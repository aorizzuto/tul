package com.tul.shoppingcart.dto

import java.math.BigDecimal
import java.util.*

class CashoutDTO (
    val products: MutableMap<UUID, Int>,
    val total: BigDecimal
        )