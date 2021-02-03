package com.redash.framework.annotation.impl;

import com.redash.framework.annotation.Interval;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 云蟾网络科技有限公司版权所有
 * @Description:
 */
public class IntervalValidator implements ConstraintValidator<Interval,Object> {

    private String[] value;
    private String message;

    @Override
    public void initialize(Interval intervalAnnotation) {
        this.value = intervalAnnotation.value();
        this.message = intervalAnnotation.message();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        String param = (String) object;
        boolean ret = false;
        for (String s : value) {
            if (s.equals(param)) {
                ret = true;
            }
        }
        return ret;
    }
}
