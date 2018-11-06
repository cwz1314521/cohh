package com.hema.newretail.backstage.controller;

import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.BoxGroupIngredientCondition;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.IngredientCondition;
import com.hema.newretail.backstage.service.IBatchingTypeManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 程文政
 * @Date: 2018/8/24 17:14
 * @Description:
 * @Version: 1.0
 */
@Api(description = "≡(▔﹏▔)≡配料类型接口")
@RestController
@RequestMapping("/ingredientsType")
public class BatchingTypeManagementController {

    @Autowired
    private IBatchingTypeManagementService batchingTypeManagementService;

    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);
    /**
     *
     * 功能描述: 查询配料组合列表接口
     *
     * @param: 
     * @return: 
     * @auther: cwz
     * @date: 2018/8/24 17:43
     */
    @ApiOperation("查询配料组合列表接口------首页列表")
    @PostMapping(value = "/mixList")
    @ResponseBody
    public Response mixList(@RequestBody IngredientCondition ingredientCondition){
        return  batchingTypeManagementService.mixList(ingredientCondition);
    }

    /**
     *
     * 功能描述: 删除配料组合列表接口
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/24 17:43
     */
    @ApiOperation("删除配料组合列表接口---首页列表删除")
    @PostMapping(value = "/mixDelete")
    @ResponseBody
    public Response mixDelete(@RequestParam(required = true)  Long id){
        return  batchingTypeManagementService.mixDelete(id);
    }

    /**
     *
     * 功能描述: 增加修改配料组合列表接口
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/24 17:43
     */

    @ApiOperation("增加/修改配料组合列表接口---首页增加修改")
    @PostMapping(value = "/mixAddEdit")
    @ResponseBody
    public Response mixAddEdit(@RequestBody @Validated BoxGroupIngredientCondition boxGroupIngredientCondition){
            return  batchingTypeManagementService.binAllocationEditAdd(boxGroupIngredientCondition);

    }

    /**
     *
     * 功能描述: 查询所有的配料接口
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/24 17:43
     */

    @ApiOperation("增加/修改配料组合列表接口---首页增加修改")
    @PostMapping(value = "/allIngredients")
    @ResponseBody
    public Response allIngredients(){
        return  batchingTypeManagementService.allIngredients();

    }

    /**
     *
     * 功能描述: 查询所有配料信息接口
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/24 17:43
     */
    @ApiOperation("查询所有配料信息接口---修改页详情列表")
    @PostMapping(value = "/ingredientInfo")
    @ResponseBody
    public Response ingredientInfo(@RequestParam(required = true) Long boxGroupId){
        return batchingTypeManagementService.ingredientInfo(boxGroupId);
    }


    /**
     *
     * 功能描述: 查询料盒分配接口
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/24 17:43
     */
    @ApiOperation("查询料盒分配接口  --13/18")
    @PostMapping(value = "/binAllocationList")
    @ResponseBody
    public Response binAllocationList(){
        return  batchingTypeManagementService.binAllocationList();
    }


}
