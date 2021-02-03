package com.redash.framework.object;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author 云蟾网络科技有限公司版权所有
 * @Description: 返回结果工具
 */
public class ResultUtil {
    public static ModelAndView view(String view) {
        return new ModelAndView(view);
    }

    public static ModelAndView view(String view, Map<String, Object> model) {
        return new ModelAndView(view, model);
    }

    public static ModelAndView redirect(String view) {
        return new ModelAndView("redirect:" + view);
    }

    public static ModelAndView forward(String view) {
        return new ModelAndView("forward:" + view);
    }

    public static ResponseEntity<Object> error(HttpStatus status) {
        ResponseVO<Object> responseVO = new ResponseVO<Object>("error", null);
        return vo(responseVO, status);
    }

    public static ResponseEntity<Object> error(String message) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ResponseVO<Object> responseVO = new ResponseVO<Object>(message, null);
        return vo(responseVO, status);
    }

    public static ResponseEntity<Object> success(String message, Object data) {
        ResponseVO<Object> responseVO = new ResponseVO<Object>(message, null);
        return vo(responseVO, HttpStatus.OK);
    }

    public static ResponseEntity<Object> success(Object data) {
        ResponseVO<Object> responseVO = new ResponseVO<Object>("success", data);
        return vo(responseVO, HttpStatus.OK);
    }

    public static ResponseEntity<Object> success(HttpStatus status) {
        ResponseVO<Object> responseVO = new ResponseVO<Object>("success", null);
        return vo(responseVO, status);
    }

    public static ResponseEntity<Object> success(String message) {
        return success(message, null);
    }

    public static ResponseEntity<Object> noContent() {
        ResponseVO<Object> responseVO = new ResponseVO<Object>("success", null);
        return vo(responseVO, HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity<Object> vo(ResponseVO<Object> responseVo, HttpStatus status) {
        return new ResponseEntity<Object>(responseVo, status);
    }
}