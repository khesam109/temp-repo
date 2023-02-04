package com.khesam.trivialspring.controller;

import com.khesam.trivialspring.common.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {AccountNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData handleException(AccountNotFoundException exception) {
        return new ErrorData("Invalid account id");
    }

}
