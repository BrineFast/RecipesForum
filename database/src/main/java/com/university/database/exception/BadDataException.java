package com.university.database.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadDataException extends RuntimeException {

    public BadDataException(String message) {
        super(message);
    }
}
