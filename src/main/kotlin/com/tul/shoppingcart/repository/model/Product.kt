package com.tul.shoppingcart.repository.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.relational.core.mapping.Column
import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
class Product (

    @Id
    @Column("id")
    val id: UUID = UUID.randomUUID(),

    @Column("name")
    val name: String,

    @Column("sku")
    val sku: String,

    @Column("description")
    val description: String,

    @Column("price")
    val price: BigDecimal,

    @Column("has_discount")
    val hasDiscount: Boolean
){
    constructor(): this(UUID.randomUUID(), "", "", "", BigDecimal.ZERO, false)
}