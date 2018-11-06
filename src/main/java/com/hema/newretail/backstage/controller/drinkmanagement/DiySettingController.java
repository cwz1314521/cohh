package com.hema.newretail.backstage.controller.drinkmanagement;

import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.diy.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.service.drinkmanagement.DiySettingService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Department 新零售
 * @ClassName DiySettingController
 * @Description 饮品管理----Diy配料设置  or  diy系统设置
 * @Author ---CWZ
 * @Date 2018/10/17 12:06
 * @Version 1.0
 **/
@Controller
@Api(description = "≡(▔﹏▔)≡Diy配料设置or系统设置接口")
@RequestMapping("/diy")
public class DiySettingController {

    @Autowired
    private DiySettingService diySettingService;
    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);
    /**
     *
     * 功能描述: 前端不需要传入参数，返回diy商品折扣前价格
     *
     * @param: null
     * @return: Price diy饮品折扣前价格
     * @author: cwz
     * @date: 2018/10/17 16:30
     */
    @PostMapping("/diyPrice")
    @ResponseBody
    @ApiOperation("显示diy商品价格")
    public Response diyPrice(){
        return diySettingService.diyPrice();
    }

    /**
     *
     * 功能描述: 传入参数，修改diy商品折扣前价格
     *
     * @param: string
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 16:30
     */
    @PostMapping("/editPrice")
    @ResponseBody
    @ApiOperation("修改diy商品价格")
    public Response editPrice(@RequestBody@Validated PriceCondition priceCondition, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.info("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return diySettingService.editPrice(priceCondition);
        }
    }
    /**
     *
     * 功能描述: DIY状态描述设置列表展示
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/17 17:42
     */
    @PostMapping("/listStatusDescription")
    @ResponseBody
    @ApiOperation("DIY状态描述设置")
    public Response diyStatusDescription(){
        return diySettingService.diyStatusDescription();
    }

    /**
     *
     * 功能描述: DIY状态描述增加修改
     *
     * @param: DiyStatusAddEditCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/17 18:18
     */

    @PostMapping("/addEditStatusDescription")
    @ResponseBody
    @ApiOperation("DIY状态描述增加修改")
    public Response addEditStatusDescription(@RequestBody@Validated DiyStatusAddEditCondition diyIdCondition, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            logger.info("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            if(diyIdCondition.getIngredientsVolumeMax() <= diyIdCondition.getIngredientsVolumeMin()){
                logger.info("体积区间输入有误......");
                return Response.failure("体积区间输入有误");
            }
            if(diyIdCondition.getId() == null){
                logger.info("转至添加......");
                return diySettingService.addStatusDescription(diyIdCondition);
            }else {
                logger.info("转至修改......");
                return diySettingService.editStatusDescription(diyIdCondition);
            }
        }
    }

    /**
     *
     * 功能描述: DIY状态描述删除
     *
     * @param: IdCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 9:57
     */
    @PostMapping("/deleteStatusDescription")
    @ResponseBody
    @ApiOperation("DIY状态描述删除")
    public Response deleteStatusDescription(@RequestBody@Validated IdCondition idCondition,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.info("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
           return diySettingService.deleteStatusDescription(idCondition);
        }
    }

    /**
     *
     * 功能描述: 配料选择---辅助接口
     *
     * @param: null
     * @return: list
     * @author: cwz
     * @date: 2018/10/18 10:30
     */
    @PostMapping("/allIngredient")
    @ResponseBody
    @ApiOperation("配料选择---辅助接口")
    public Response allIngredient(){
        return diySettingService.allIngredient();
    }


    /**
     *
     * 功能描述: 配料事件---列表
     *
     * @param: NameCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/18 10:50
     */
    @PostMapping("/listEvent")
    @ResponseBody
    @ApiOperation("配料事件---列表")
    public Response listEvent(@RequestBody@Validated NameCondition nameCondition,BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            logger.info("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return diySettingService.listEvent(nameCondition);
        }
    }

    /**
     *
     * 功能描述:
     *
     * @param: IdCondition
     * @return: detail
     * @author: cwz
     * @date: 2018/10/18 12:11
     */
    @PostMapping("/detailEvent")
    @ResponseBody
    @ApiOperation("配料事件---编辑detail")
    public Response detailEvent(@RequestBody@Validated IdCondition idCondition,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.info("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return diySettingService.detailEvent(idCondition);
        }
    }


    /**
     *
     * 功能描述:配料事件---编辑添加
     *
     * @param: AddEditEventCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 12:11
     */
    @PostMapping("/addEditEvent")
    @ResponseBody
    @ApiOperation("配料事件---编辑添加")
    public Response addEditEvent(@RequestBody@Validated AddEditEventCondition addEditEventCondition,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.info("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
                return diySettingService.addEditEvent(addEditEventCondition);
        }
    }

    /**
     *
     * 功能描述: 配料事件---删除
     *
     * @param: IdCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/18 14:52
     */
    @PostMapping("/deleteEvent")
    @ResponseBody
    @ApiOperation("配料事件---删除")
    public Response deleteEvent(@RequestBody@Validated IdCondition idCondition,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            logger.info("数据校验没通过......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
                return diySettingService.deleteEvent(idCondition);
        }
    }
}
