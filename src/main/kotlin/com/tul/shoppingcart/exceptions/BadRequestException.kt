package com.tul.shoppingcart.exceptions

class BadRequestException(val errorCode: ErrorCode): Exception(errorCode.msg)