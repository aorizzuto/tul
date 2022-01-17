package com.tul.shoppingcart.repository

import com.tul.shoppingcart.repository.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, String>