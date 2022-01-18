package com.tul.shoppingcart.repository.model

import com.tul.shoppingcart.enums.StatusEnum
import org.springframework.data.relational.core.mapping.Column
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "carts")
class Cart (

    @Id
    @Column("id")
    val id: UUID = UUID.randomUUID(),

    @Column("orders")
    @OneToMany
    val orders: MutableList<Order>,

    @Column("status")
    var status: String,
){
    constructor(): this(UUID.randomUUID(), mutableListOf(), StatusEnum.PENDING.value)
}