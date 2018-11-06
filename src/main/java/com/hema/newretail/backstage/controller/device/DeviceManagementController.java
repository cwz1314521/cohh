package com.hema.newretail.backstage.controller.device;

import com.hema.newretail.backstage.common.queryparam.device.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.service.device.DeviceManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Department 新零售
 * @ClassName DeviceManagement
 * @Description 设备管理----Controller
 * @Author ---CWZ
 * @Date 2018/10/11 13:18
 * @Version 1.0
 **/

@Api(description = "≡(▔﹏▔)≡设备管理相关接口")
@Controller
@RequestMapping("/device")
public class DeviceManagementController {


    @Autowired
    private DeviceManagementService deviceManagementService;


    /**
     * 设备申请----------------------------------------------------------------------------------------------------------
     */
    /**
     *
     * 功能描述: 设备申请列表
     *
     * @param: DeviceApplyListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/11 14:33
     */
    @PostMapping(value = "/deviceApplyList")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡申请设备列表----历史记录-----详情")
    public Response deviceApplyList(@RequestBody @Validated DeviceApplyListCondition deviceApplyListCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return deviceManagementService.deviceApplyList(deviceApplyListCondition);
        }
    }


    /**
     *
     * 功能描述: 设备申请列表
     *
     * @param: DeviceApplyListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/11 14:33
     */
    @PostMapping(value = "/excelDeviceApply")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡申请设备列表----历史记录-----详情")
    public Response excelDeviceApply(@RequestBody @Validated DeviceApplyListCondition deviceApplyListCondition)throws Exception{

            return deviceManagementService.excel(deviceApplyListCondition);
    }

    /**
     *
     * 功能描述:新增申请设备
     *
     * @param: AddDeviceApplyCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 15:17
     */
    @PostMapping(value = "/addDeviceApply")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡新增申请设备")
    public Response addDeviceApply(@RequestBody @Validated AddDeviceApplyCondition addDeviceApplyCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return deviceManagementService.addDeviceApply(addDeviceApplyCondition);
        }
    }



    /**
     * 设备合作----------------------------------------------------------------------------------------------------------
     */
    /**
     *
     * 功能描述: 设备合作列表----详情
     *
     * @param: DeviceCooperationListCondition
     * @return: cooperationList
     * @author: cwz
     * @date: 2018/10/11 15:54
     */
    @PostMapping(value = "/cooperationList")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡设备合作列表-----详情")
    public Response  cooperationList(@RequestBody @Validated DeviceCooperationListCondition deviceCooperationListCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return deviceManagementService.cooperationList(deviceCooperationListCondition);
        }
    }

    /**
     *
     * 功能描述: 设备申请列表
     *
     * @param: DeviceApplyListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/11 14:33
     */
    @PostMapping(value = "/excelCooperation")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡申请设备列表----excel导出")
    public Response excelCooperation(@RequestBody @Validated DeviceCooperationListCondition deviceCooperationListCondition)throws Exception{

        return deviceManagementService.excelCooperation(deviceCooperationListCondition);
    }

    /**
     *
     * 功能描述:申请设备列表----申请号查询
     *
     * @param: QueryCooperationCondition
     * @return: detail
     * @author: cwz
     * @date: 2018/10/11 16:27
     */
    @PostMapping(value = "/queryCooperation")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡申请设备列表----申请号查询")
    public Response queryCooperation(@RequestBody @Validated QueryCooperationCondition queryCooperationCondition){

        return deviceManagementService.queryCooperation(queryCooperationCondition);
    }

    /**
     *
     * 功能描述:申请设备列表----申请号新增
     *
     * @param: QueryCooperationCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 16:27
     */
    @PostMapping(value = "/addCooperation")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡申请设备列表----申请号新增")
    public Response addCooperation(@RequestBody @Validated AddCooperationCondition addCooperationCondition){

        return deviceManagementService.addCooperation(addCooperationCondition);
    }

    /**
    * ----出库管理----------------------------------------------------------------------------------------------------------
    */

}
