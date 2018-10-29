package com.homework.postaldistance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Milos
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LatAndLngNotValidException extends RuntimeException{
    
    public LatAndLngNotValidException(String exception) {
        super(exception);
    }
}
