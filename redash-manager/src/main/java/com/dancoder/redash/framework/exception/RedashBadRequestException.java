package com.dancoder.redash.framework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dancoder
 */
public class RedashException extends RuntimeException{

    /**
     * @param message
     */
    public RedashException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public RedashException(String message, Throwable cause) {
        super(message, cause);
    }
}
