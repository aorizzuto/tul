package com.tul.shoppingcart.repository.model

import org.springframework.data.relational.core.mapping.Column
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order (

    @Id
    @Column("id")
    val id: UUID = UUID.randomUUID(),

    @Column("product_id")
    @OneToOne
    var product: Product,

    @Column("quantity")
    var quantity: Int,
){
    constructor(): this(UUID.randomUUID(), Product(), 0)
}