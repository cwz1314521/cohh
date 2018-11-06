package com.hema.newretail.backstage.controller.agent;

import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.CommomPageCondition;
import com.hema.newretail.backstage.common.queryparam.agent.*;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.CentralBillListCondition;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.agent.AgentUserEntry;
import com.hema.newretail.backstage.service.agent.AgentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Department 新零售
 * @ClassName AgentController
 * @Description 本controller是代理公司各接口的controller
 * @Author ---CWZ
 * @Date 2018/9/21 9:17
 * @Version 1.2 --- 产品10.26修改代理 - C
 **/
@Api(description = "≡(▔﹏▔)≡代理公司相关接口")
@Controller
@RequestMapping("/agency")
public class AgentController {

    @Autowired
    private AgentService agentService;


    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);


    /**
     *
     * 功能描述:展示代理公司列表
     *
     * @param: AgentListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/list")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡代理公司列表")
    public Response list(@RequestBody @Validated AgentListCondition agentListCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("参数验证失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            logger.info("参数验证成功，执行service......");
            return agentService.list(agentListCondition);
        }
    }
    /**
     *
     * 功能描述: 代理excle导出
     *
     * @param: HttpServletRequest request, HttpServletResponse response,@RequestBody @Validated AgentListCondition agentListCondition
     * @return: excle
     * @author: cwz
     * @date: 2018/10/11 11:30
     */
    @GetMapping(value = "/excel")
    @ApiOperation("excel导出  代理")
    @ResponseBody
    public Response excel(HttpServletRequest request, HttpServletResponse response,AgentListCondition agentListCondition)throws Exception{
        logger.info("开始执行导出service......");
        return  agentService.excle(request,response,agentListCondition);

    }

    /**
     *
     * 功能描述:添加代理公司
     *
     * @param: entry
     * @return: success
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡添加代理")
    public Response add(@RequestBody @Validated AddAgentCondition AddAgentCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("参数验证失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            logger.info("参数验证成功......");
            return agentService.add(AddAgentCondition);
        }
    }

    /**
     *
     * 功能描述:修改代理公司
     *
     * @param: entry
     * @return: success
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/edit")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡修改代理")
    public Response edit(@RequestBody @Validated EditAgentCondition editAgentCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("参数验证失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            logger.info("参数验证成功......");
            return agentService.edit(editAgentCondition);
        }
    }


    /**
     *
     * 功能描述:删除代理公司
     *
     * @param: id
     * @return: success
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡删除代理")
    public Response delete(@RequestBody @Validated DeleteAgentCondition deleteAgentCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("参数验证失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            logger.info("参数验证成功......");
            return agentService.delete(deleteAgentCondition.getId());
        }
    }


    /**
     *
     * 功能描述:代理数据统计
     *
     * @param:
     * @return: success
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/listStatistics")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡代理数据统计")
    public Response listStatistics(@RequestBody  @Validated AgentListCondition agentListConditio, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("参数验证失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            logger.info("参数验证成功......");
            return agentService.listStatistics();
        }
    }
    /**
     *
     * 功能描述: 消息推送
     *
     * @param:
     * @return: success
     * @author: cwz
     * @date: 2018/10/26 17:37
     */
    @PostMapping(value = "/push")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡消息推送")
    public Response push(@RequestBody @Validated PushCondition pushCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("参数验证失败......."+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            logger.info("参数验证成功......");
            return agentService.push(pushCondition);
        }
    }

    /**
     *
     * 功能描述: 推送历史
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/26 17:37
     */
    @PostMapping(value = "/pushHistory")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡推送历史")
    public Response pushHistory(@RequestBody @Validated CommomPageCondition commomPageCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("参数验证失败........"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            logger.info("参数验证成功.......");
            return agentService.pushHistory(commomPageCondition);
        }
    }


}
