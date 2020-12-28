package com.dancoder.redash.framework.handle;

import com.dancoder.redash.framework.exception.RedashBadRequestException;
import com.dancoder.redash.framework.object.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author dancoder
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 统一拦截异常
     * @param exception 异常类
     * @return
     */
    @ExceptionHandler(value = RedashBadRequestException.class)
    public ResponseEntity<ResponseVO> handleHttpException(RedashBadRequestException exception) {
        HttpStatus status = HttpStatus.resolve(exception.getHttpStatus());
        ResponseVO responseVO = new ResponseVO(exception.getHttpStatus(), exception.getMessage(), null);
        return new ResponseEntity<>(responseVO,status);
    }
}
