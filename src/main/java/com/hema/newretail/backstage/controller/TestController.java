package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.queryparam.agent.TestControllerCondition;
import com.hema.newretail.backstage.common.utils.Response;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.controller
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-09-07 12:12
 */
@Controller
@RequestMapping("test")
public class TestController {

    @PostMapping(value = "/hello")
    @ResponseBody
    public Response hello(@RequestBody @Validated TestControllerCondition testControllerCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
                System.out.println("in hello....");
                return Response.success("hell0");
        }

    }

}
