package com.dancoder.redash.framework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dancoder
 */
public class RedashBadRequestException extends RuntimeException{

    /**
     * @param message
     */
    public RedashBadRequestException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public RedashBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
