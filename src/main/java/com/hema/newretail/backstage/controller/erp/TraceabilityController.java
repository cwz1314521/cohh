package com.hema.newretail.backstage.controller.erp;

import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.erp.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.service.erp.TraceabilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Department 新零售
 * @ClassName ErpController
 * @Description 溯源系统总后台controller
 * @Author ---CWZ
 * @Date 2018/10/30 13:40
 * @Version 1.0
 **/
@Api(description =  "≡(▔﹏▔)≡溯源总后台相关接口")
@Controller
@RequestMapping("/manufacturer")
public class TraceabilityController {

    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);

    @Autowired
    private TraceabilityService traceabilityService;

    /*原料厂商*/
    /**
     *
     * 功能描述:原料厂商---总后台列表展示
     *
     * @param:
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡原料厂商---总后台列表展示")
    @PostMapping("/list")
    @ResponseBody
    public Response manufacturerList(@RequestBody@Validated ManufacturerListCondition manufacturerListCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.manufacturerList(manufacturerListCondition);
        }
    }

    /**
     *
     * 功能描述:原料厂商---添加
     *
     * @param: ManufacturerAddCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡原料厂商---添加")
    @PostMapping("/add")
    @ResponseBody
    public Response manufacturerAdd(@RequestBody@Validated ManufacturerAddCondition manufacturerAddCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.manufacturerAdd(manufacturerAddCondition);
        }
    }

    /**
     *
     * 功能描述:原料厂商---编辑
     *
     * @param: ManufacturerEditCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡原料厂商---编辑")
    @PostMapping("/edit")
    @ResponseBody
    public Response manufacturerEdit(@RequestBody@Validated ManufacturerEditCondition manufacturerEditCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.manufacturerEdit(manufacturerEditCondition);
        }
    }



    /*订单*/
    /**
     *
     * 功能描述:订单列表
     *
     * @param: OrderListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡订单列表")
    @PostMapping("/orderList")
    @ResponseBody
    public Response orderList(@RequestBody@Validated OrderListCondition orderListCondition, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.orderList(orderListCondition);
        }
    }

    /**
     *
     * 功能描述: 列表-查询原料厂商
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡列表-查询原料厂商")
    @PostMapping("/listManufacturer")
    @ResponseBody
    public Response listManufacturer(@RequestBody@Validated ListManufacturerCondition listManufacturerCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.listManufacturer(listManufacturerCondition);
        }

    }

    /**
     *
     * 功能描述: 查询送货地址（分公司）
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡查询送货地址（分公司）")
    @PostMapping("/listAddress")
    @ResponseBody
    public Response listAddress(@RequestBody@Validated ListManufacturerCondition listManufacturerCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.listAddress(listManufacturerCondition);
        }

    }


    /**
     *
     * 功能描述: 查询原料
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡查询原料")
    @PostMapping("/listIngredient")
    @ResponseBody
    public Response listIngredient(@RequestBody@Validated ListManufacturerCondition listManufacturerCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.listIngredient(listManufacturerCondition);
        }

    }

    /**
     *
     * 功能描述:订单添加
     *
     * @param: OrderListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/31 9:43
     */
    @ApiOperation("≡(▔﹏▔)≡订单添加")
    @PostMapping("/orderAdd")
    @ResponseBody
    public Response orderAdd(@RequestBody@Validated OrderAddCondition orderAddCondition, BindingResult bindingResult)throws Exception{
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.orderAdd(orderAddCondition);
        }
    }

    /*分后台*/
    /**
     *
     * 功能描述:分后台  列表
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    @ApiOperation("≡(▔﹏▔)≡ 分后台---列表")
    @PostMapping("/inStoreList")
    @ResponseBody
    public Response inStoreList(@RequestBody@Validated InStoreListCondition inStoreListCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.inStoreList(inStoreListCondition);
        }
    }

    /**
     *
     * 功能描述:分后台  当天未入库列表
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    @ApiOperation("≡(▔﹏▔)≡ 分后台---当天未入库列表")
    @PostMapping("/inStoreToday")
    @ResponseBody
    public Response inStoreToday(){
            return traceabilityService.inStoreToday();
    }

    /**
     *
     * 功能描述:分后台  提交入库
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    @ApiOperation("≡(▔﹏▔)≡ 分后台---提交入库")
    @PostMapping("/inStoreInStore")
    @ResponseBody
    public Response inStoreInStore(@RequestBody@Validated InStoreInStoreCondition inStoreInStoreCondition, HttpServletRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.inStoreInStore(request,inStoreInStoreCondition);
        }
    }

    /**
     *
     * 功能描述:分后台  输入串码入库
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    @ApiOperation("≡(▔﹏▔)≡ 分后台---输入串码入库")
    @PostMapping("/inStoreNum")
    @ResponseBody
    public Response inStoreNum(@RequestBody@Validated InStoreNumCondition inStoreNumCondition, HttpServletRequest request,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.inStoreNum(request,inStoreNumCondition);
        }
    }

    /**
     *
     * 功能描述:分后台  入库记录--列表
     *
     * @param: InStoreListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/11/2 14:07
     */
    @ApiOperation("≡(▔﹏▔)≡ 分后台---入库记录--列表")
    @PostMapping("/inStoreRecordList")
    @ResponseBody
    public Response inStoreRecordList(@RequestBody@Validated InStoreRecordListCondition inStoreRecordListCondition, BindingResult bindingResult)throws Exception{
        if (bindingResult.hasErrors()) {
            logger.error("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return traceabilityService.inStoreRecordList(inStoreRecordListCondition);
        }
    }
}
