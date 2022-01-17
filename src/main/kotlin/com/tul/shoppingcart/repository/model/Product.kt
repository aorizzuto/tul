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
    var name: String,

    @Column("sku")
    var sku: String,

    @Column("description")
    var description: String,

    @Column("price")
    var price: BigDecimal,

    @Column("has_discount")
    var hasDiscount: Boolean
){
    constructor(): this(UUID.randomUUID(), "", "", "", BigDecimal.ZERO, false)
}