package com.redash.framework.object;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * controller返回json
 * @author dancoder
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseVO<T> {
    private String message;
    private T data;

    public ResponseVO(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResponseVO(String message) {
        this.message = message;
    }

//    public String toJson() {
//        T t = this.getData();
//        if (t instanceof List || t instanceof Collection) {
//            return JSONObject.toJSONString(this, SerializerFeature.WriteNullListAsEmpty);
//        } else {
//            return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
//        }
//    }
}