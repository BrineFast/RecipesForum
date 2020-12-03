package com.university.database.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ClientRegistrationIdNotFound extends RuntimeException {

    public ClientRegistrationIdNotFound(String message) {
        super(message);
    }
}
