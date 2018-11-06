package com.hema.newretail.backstage.common.validator;

import com.hema.newretail.backstage.common.utils.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.config
 *
 * @author zhs
 * @link
 * @date 2018-08-31 9:50
 */
@ControllerAdvice
public class ExceptionAdvice {
    /**
     * 拦截捕捉自定义异常
     *
     * @param ex 异常
     * @return 返回异常信息
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response constraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<String> msgList = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            msgList.add(cvl.getMessageTemplate());
        }
        return Response.failureValid(msgList);
    }
}
