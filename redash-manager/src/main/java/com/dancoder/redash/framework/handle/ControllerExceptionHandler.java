package com.dancoder.redash.framework.handle;

import com.dancoder.redash.framework.exception.RedashBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dancoder
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 捕获全局异常，处理可知的bad异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RedashBadRequestException.class)
    Object handleException(Exception e) {
        Map<String, Object> map = new HashMap<>(3);
        map.put("message", e.getMessage());
        return map;
    }

    /**
     * 捕获全局异常，处理可知的bad异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    Object handleUnknownException(Exception e) {
        Map<String, Object> map = new HashMap<>(3);
        map.put("message", e.getMessage());
        return map;
    }
}
