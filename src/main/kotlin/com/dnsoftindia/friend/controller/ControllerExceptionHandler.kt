package com.dnsoftindia.friend.controller

import com.dnsoftindia.friend.util.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.ValidationException

@ControllerAdvice
class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException::class)
    fun handleException(e: ValidationException): ErrorMessage {
        return ErrorMessage("400", e.message)
    }

}