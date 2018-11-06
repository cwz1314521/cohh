package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.queryparam.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseCompanyData;
import com.hema.newretail.backstage.entry.BaseUserInfoEntry;
import com.hema.newretail.backstage.service.IBaseCompanyGeoHashService;
import com.hema.newretail.backstage.service.IBaseCompanyService;
import com.hema.newretail.backstage.service.IBaseUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 分公司管理
 * @Author: Mr.Yang
 * @Date: 2018/09/25
 **/
@Api(description =  "分公司管理接口")
@Controller
@RequestMapping("/baseCompany")
public class BaseCompanyController {

    @Autowired
    private IBaseCompanyService baseCompanyService;

    @Autowired
    private IBaseUserInfoService baseUserInfoService;

    @Autowired
    private IBaseCompanyGeoHashService baseCompanyGeoHashService;

    @Value(value = "${custom.initUserPassWord}")
    private String initUserPassWord;

    @ApiOperation("保存分公司信息接口")
    @PostMapping("/save")
    @ResponseBody
    public Response saveBaseCompany(@Validated @RequestBody BaseCompanyData data,BindingResult result){
        if(result.hasErrors()){
            return Response.failure(result.getFieldError().getDefaultMessage());
        }else {
            int n = baseCompanyService.saveBaseCompany(data);
            if(n>0){
                return Response.success(data.getId());
            }else{
                return Response.failure();
            }
        }
    }

    @ApiOperation("改变分公司状态接口")
    @PostMapping("/updateStatus")
    @ResponseBody
    public Response updateStatusById(Long id,int status){
        BaseCompanyData data = new BaseCompanyData();
        data.setId(id);
        data.setStatus(status);
        int n = baseCompanyService.updateStatusById(data);
        if(n>0){
            return Response.success();
        }else {
            return Response.failure();
        }
    }

    @ApiOperation("初始化分公司登录密码接口")
    @PostMapping("/initPassword")
    @ResponseBody
    public Response initPasswordById(@RequestBody Long id){
        BaseUserInfoEntry baseUserInfoEntry = baseUserInfoService.findOneByCompanyId(id);
        if(baseUserInfoEntry!=null){
            baseUserInfoEntry.setUserPassword(initUserPassWord);
            int n = baseUserInfoService.initUserPassWord(baseUserInfoEntry);
            if (n>0){
                return Response.success();
            }else{
                return Response.failure("更新失败");
            }
        }else{
            return Response.failure("公司账号不存在,请检查用户是否存在");
        }
    }

    @ApiOperation("删除分公司信息接口")
    @PostMapping("/deleteById")
    @ResponseBody
    public Response deleteById(@RequestBody@Validated BaseCompanyDeleteParameter baseCompanyDeleteParameter, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            int count = baseCompanyGeoHashService.countByBaseCompanyId(baseCompanyDeleteParameter.getId());
            if (count > 0) {
                return Response.failure("分公司已经分配服务区域，无法删除。");
            } else {
                int n = baseCompanyService.deleteById(baseCompanyDeleteParameter.getId());
                if (n > 0) {
                    return Response.success();
                } else {
                    return Response.failure("删除失败");
                }
            }
        }
    }

    @ApiOperation("查询分公司信息接口")
    @PostMapping("/findAll")
    @ResponseBody
    public Response findAll(@RequestBody BaseCompanyQueryParameter params){
        return baseCompanyService.findAll(params);
    }

    @ApiOperation("保存分公司网格信息接口")
    @PostMapping("/saveGeoHash")
    @ResponseBody
    public Response saveBaseCompanyGeoHash(@RequestBody BaseCompanyGeoHashSaveParameter parameter){
        String result = baseCompanyService.saveBaseCompanyGeoHash(parameter);
        if("".equals(result)){
            return Response.success();
        }else{
            return Response.failure(result);
        }
    }

    @ApiOperation("地图模式-查询分公司服务区域接口")
    @PostMapping("/findServiceAreaByCompanyId")
    @ResponseBody
    public Response findServiceArea(@RequestBody BaseCompanyDeleteParameter id){
        return Response.success(baseCompanyGeoHashService.findServiceAreaByBaseCompanyId(id));
    }

    @ApiOperation("地图模式-根据地市或关键字查询分公司名称接口")
    @PostMapping("/findBaseCompanyNameByArea")
    @ResponseBody
    public Response findBaseCompanyNameByArea(@RequestBody BaseCompanyNameQueryParameter parameter){
        return baseCompanyService.findBaseCompanyByArea(parameter);
    }

    @ApiOperation("地图模式-根据地图地址查询分公司网格接口")
    @PostMapping("/findBaseCompaniesByMap")
    @ResponseBody
    public Response findBaseCompaniesByMap(@RequestBody BaseCompanyGeoHashInitMapParameter parameter){
        return Response.success(baseCompanyService.findCompaniesByMap(parameter.getMapGeoHash()));
    }

    @ApiOperation("验证公司名称是否唯一")
    @PostMapping("/verifyCompanyName")
    @ResponseBody
    public Response verifyCompanyName(@Validated @RequestBody BaseCompanyNameParameter parameter, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        }else {
            int count = baseCompanyService.countByCompanyName(parameter);
            if(count>0){
                return Response.failure("公司名称已存在");
            }else {
                return Response.success();
            }
        }
    }
}
