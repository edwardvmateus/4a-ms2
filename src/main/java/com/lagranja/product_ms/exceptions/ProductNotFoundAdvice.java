package com.lagranja.product_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.security.auth.login.AccountNotFoundException;

@ControllerAdvice
@ResponseBody

public class ProductNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(ProductNotFoundException ex){
        return ex.getMessage();
    }
}
