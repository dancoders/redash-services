package com.redash.common.config;

//import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author 云蟾网络科技有限公司版权所有
 * @Description:
 */
@Configuration
public class WebConfig {
//    @Bean
//    public Validator validator() {
//        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
//                .configure()
//                //failFast的意思只要出现校验失败的情况，就立即结束校验，不再进行后续的校验。
//                .failFast(true)
//                .buildValidatorFactory();
//        return validatorFactory.getValidator();
//    }

//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
//        methodValidationPostProcessor.setValidator(validator());
//        return methodValidationPostProcessor;
//    }
}
