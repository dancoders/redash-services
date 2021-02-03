package com.redash.framework.exception;

/**
 * @author dancoder
 */
public class RedashBadRequestException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Integer httpStatus;

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

    public RedashBadRequestException(Integer httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }


    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }
}
