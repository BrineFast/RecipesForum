package com.university.database.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class AccountAlreadyUsingException extends RuntimeException {

    public AccountAlreadyUsingException(String message) {
        super(message);
    }
}
