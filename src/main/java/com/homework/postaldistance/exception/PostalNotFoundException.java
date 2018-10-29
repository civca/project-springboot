package com.homework.postaldistance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Milos
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostalNotFoundException extends RuntimeException{

    public PostalNotFoundException(String exception) {
        super(exception);
    }
}
