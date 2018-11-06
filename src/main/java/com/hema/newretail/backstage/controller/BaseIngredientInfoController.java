package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.service.IBaseIngredientInfoDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(description = "配料管理接口")
@RestController
@RequestMapping(value = "/baseIngredientInfo")
public class BaseIngredientInfoController {

    private static final String DELETESUCCESS = "删除成功";

    @Autowired
    private IBaseIngredientInfoDataService baseIngredientInfoService;

    /**
     *配料管理列表接口
     * @param params {pageNum:int(必填),pageSize:int(必填),keyword:String(可选)}
     * @return
     */
    @ApiOperation(value = "配料管理列表接口")
    @PostMapping("/findAll")
    @ResponseBody
    public Response findAll(@RequestBody Map<String,Object> params){
        return baseIngredientInfoService.findAll(params);
    }

    /**
     *配料管理详情接口
     * @param id
     * @return
     */
    @ApiOperation(value = "配料管理详情接口")
    @PostMapping("/findOneById")
    public Response findOneById(@RequestBody long id){
        return Response.success(baseIngredientInfoService.findOneById(id));
    }

    /**
     *配料保存接口
     * @param data
     * @return
     */
    @ApiOperation(value = "配料保存接口")
    @PostMapping("/saveBaseIngredientInfo")
    public Response saveBaseIngredientInfo(@Validated @RequestBody BaseIngredientInfoEntry data, BindingResult result){
        if(result.hasErrors()){
            return Response.failure(result.getFieldError().getDefaultMessage());
        }else {
            if(baseIngredientInfoService.save(data)){
                return Response.success();
            }else{
                return Response.failure();
            }
        }
    }

    /**
     * 配料删除接口
     * @param id
     * @return
     */
    @ApiOperation(value = "配料删除接口")
    @PostMapping("/deleteBaseIngredientInfo")
    public Response deleteBaseIngredientInfo(long id){
        String result = baseIngredientInfoService.deleteById(id);
        if (DELETESUCCESS.equals(result)){
            return Response.success();
        }else{
            return Response.failure(result);
        }
    }
}
