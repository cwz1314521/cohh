package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashInitMapParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashQueryParameter;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.service.IBaseCompanyGeoHashService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 分公司网格管理接口
 * @Author: Mr.Yang
 * @Date: 2018/10/10
 **/
@Api(description =  "分公司网格管理接口")
@Controller
@RequestMapping("/baseCompanyGeoHash")
public class BaseCompanyGeoHashController {

    @Autowired
    private IBaseCompanyGeoHashService baseCompanyGeoHashService;

    @ApiOperation("分公司管理-初始化分公司网格接口--返回已经占用的网格Hash")
    @PostMapping("/initMap")
    @ResponseBody
    public Response initMapByGeoHash(@RequestBody BaseCompanyGeoHashInitMapParameter parameter){
        return Response.success(baseCompanyGeoHashService.initMapGeoHash(parameter));
    }

    @ApiOperation("分公司管理-分公司网格接口包括其他公司占有的网格")
    @PostMapping("/queryBaseCompanyGeoHash")
    @ResponseBody
    public Response queryBaseCompanyGeoHash(@RequestBody BaseCompanyGeoHashQueryParameter parameter){
        return Response.success(baseCompanyGeoHashService.queryBaseCompanyGeoHash(parameter));
    }
}
