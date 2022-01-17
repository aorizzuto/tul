package com.tul.shoppingcart.repository

import com.tul.shoppingcart.repository.model.Product
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : CrudRepository<Product, UUID>