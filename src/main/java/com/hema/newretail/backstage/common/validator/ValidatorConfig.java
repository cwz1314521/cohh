package com.hema.newretail.backstage.common.validator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.config
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-08-31 9:38
 */
@Configuration
@EnableAutoConfiguration
public class ValidatorConfig {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
