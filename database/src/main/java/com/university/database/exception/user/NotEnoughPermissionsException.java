package com.university.database.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class NotEnoughPermissionsException extends RuntimeException {

    public NotEnoughPermissionsException(String message) {
        super(message);
    }
}
