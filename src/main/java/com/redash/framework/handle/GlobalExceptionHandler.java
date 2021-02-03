package com.redash.framework.handle;

import com.redash.framework.exception.RedashBadRequestException;
import com.redash.framework.object.ResponseVO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author 云蟾网络科技有限公司版权所有
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一拦截自定义 AdvAnalysisException 异常
     *
     * @param exception 异常类
     * @return ResponseEntity
     */
    @ExceptionHandler(value = RedashBadRequestException.class)
    public ResponseEntity<Object> handleHttpException(RedashBadRequestException exception) {
        exception.printStackTrace();
        HttpStatus status = HttpStatus.resolve(exception.getHttpStatus());
        if (null == status) {
            status = HttpStatus.BAD_REQUEST;
        }
        ResponseVO<Object> responseVO = new ResponseVO<Object>(exception.getMessage(), null);
        return new ResponseEntity<>(responseVO, status);
    }

    /**
     * 统一拦截 IllegalArgumentException 异常
     *
     * @param exception 异常对象
     * @return ResponseEntity
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleHttpException(IllegalArgumentException exception) {
        exception.printStackTrace();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseVO<Object> responseVO = new ResponseVO<Object>(exception.getMessage(), null);
        return new ResponseEntity<>(responseVO, status);
    }

    /**
     * 统一拦截 Exception 异常
     *
     * @param exception 异常对象
     * @return ResponseEntity
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleHttpException(Exception exception) {
        exception.printStackTrace();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = exception.getMessage();
        if (null != exception.getCause()) {
            message = exception.getCause().getMessage();
        }
        ResponseVO<Object> responseVO = new ResponseVO<Object>(message, null);
        return new ResponseEntity<>(responseVO, status);
    }


    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        String message = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseVO<Object> responseVO = new ResponseVO<Object>(message, null);
        return new ResponseEntity<>(responseVO, status);
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseEntity<Object> bindExceptionHandler(BindException e) {
        e.printStackTrace();
        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        ResponseVO<Object> responseVO = new ResponseVO<Object>(message, null);
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是ConstraintViolationException
     * @param e
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> constraintViolationExceptionHandler(ConstraintViolationException e) {
        e.printStackTrace();
        String message = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseVO<Object> responseVO = new ResponseVO<Object>(message, null);
        return new ResponseEntity<>(responseVO, status);
    }
}
