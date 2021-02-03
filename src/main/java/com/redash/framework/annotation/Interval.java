package com.redash.framework.annotation;

import com.redash.framework.annotation.impl.IntervalValidator;
import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 云蟾网络科技有限公司版权所有
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = IntervalValidator.class)
public @interface Interval {
    /**
     * 区间的值
     * @return
     */
    String[] value();

    String message() default "";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
