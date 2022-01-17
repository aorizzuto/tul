package com.tul.shoppingcart.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException::class)
    fun handlerBadRequest(exception: BadRequestException, request: WebRequest): ResponseEntity<ResponseEntityBody> {
        return parseBodyFromErrorCode(exception.errorCode)
    }

    fun parseBodyFromErrorCode(code: ErrorCode) = ResponseEntity.status(code.errorCode).body(ResponseEntityBody(code))
}