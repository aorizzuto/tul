package com.tul.shoppingcart.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*

enum class ErrorCode (val msg: String, val errorCode: HttpStatus) {

    DESCRIPTION_NOT_FOUND("Description field is missing", BAD_REQUEST),
    NAME_NOT_FOUND("Name field is missing", BAD_REQUEST),
    PRICE_NOT_FOUND("Price field is missing", BAD_REQUEST),
    SKU_NOT_FOUND("SKU field is missing", BAD_REQUEST),
    ID_NOT_FOUND("ID is missing in request", BAD_REQUEST),
    NOT_NULL_EXPECTED("At least one field not null is expected", BAD_REQUEST),
    PRODUCT_NOT_FOUND("Product not found", NOT_FOUND),
}