package com.tul.shoppingcart.enums

enum class StatusEnum (val value: String, description: String) {
    PENDING("PENDING", "El carrito se encuentra pendiente"),
    COMPLETED("COMPLETED", "El carrito fue completado")
}