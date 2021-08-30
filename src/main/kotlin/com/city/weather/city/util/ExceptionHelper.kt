package com.city.weather.city.util

import org.apache.commons.lang3.StringUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingPathVariableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.security.InvalidParameterException

@RestControllerAdvice
class ExceptionHelper {

    @ExceptionHandler(value = [InvalidParameterException::class])
    fun handleInvalidInputException(ex: InvalidParameterException): ResponseEntity<Any> = ResponseEntity(
        StringUtils.join("Input param is not valid. Message: ", ex.message),
        HttpStatus.BAD_REQUEST
    )

    @ExceptionHandler(value = [NoSuchElementException::class])
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<Any> =
        ResponseEntity(StringUtils.join("Element not found. Message: ", ex.message), HttpStatus.BAD_REQUEST)


    @ExceptionHandler(value = [IllegalArgumentException::class])
    fun handleIllegalArgumentException(ex: IllegalArgumentException?): ResponseEntity<Any> =
        ResponseEntity("Input param is not valid!", HttpStatus.BAD_REQUEST)


//    @ExceptionHandler(value = [Exception::class])
//    fun handleException(ex: Exception): ResponseEntity<Any> =
//        ResponseEntity(StringUtils.join("Error message: ", ex.message), HttpStatus.INTERNAL_SERVER_ERROR)


    @ExceptionHandler(value = [MissingPathVariableException::class])
    fun handleMissingPathVariableException(ex: MissingPathVariableException): ResponseEntity<Any> =
        ResponseEntity(StringUtils.join("Invalid path param. Message: ", ex.message), HttpStatus.BAD_REQUEST)
}