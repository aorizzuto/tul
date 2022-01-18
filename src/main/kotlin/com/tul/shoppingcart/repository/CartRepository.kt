package com.tul.shoppingcart.repository

import com.tul.shoppingcart.repository.model.Cart
import com.tul.shoppingcart.repository.model.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CartRepository : CrudRepository<Cart, UUID> {

    fun findByStatus(status: String): Cart
}