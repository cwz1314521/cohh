package com.hema.newretail.backstage.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.enums.ResultCode;
import com.hema.newretail.backstage.model.menu.IngredientMenuBo;
import com.hema.newretail.backstage.service.IIngredientMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hema-newetaril-com.hema.newretail.backstage.controller
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-23 11:14
 */
@Api(description = "饮品管理接口")
@RestController
@Validated
@RequestMapping("/menu")
public class IngredientMenuController {

    @Autowired
    private IIngredientMenuService ingredientMenuService;

    /**
     * 查询饮品，分页显示
     *
     * @param pageNum         页码
     * @param pageSize        每页数据条数
     * @param menuName        饮品名称
     * @param priceStart      饮品价格起始值
     * @param priceEnd        饮品价格结束值
     * @param saleNumStart    销售量起始值
     * @param saleNumEnd      销售量结束值
     * @param saleAmountStart 销售额起始值
     * @param saleAmountEnd   销售量结束值
     * @param isRecommend     是否推荐
     * @param status          展示状态
     * @return
     */
    @ApiOperation("查询饮品，分页显示")
    @PostMapping(value = "/list")
    public Response list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                         @RequestParam(value = "menuName", required = false) String menuName,
                         @RequestParam(value = "priceStart", required = false) String priceStart,
                         @RequestParam(value = "priceEnd", required = false) String priceEnd,
                         @RequestParam(value = "saleNumStart", required = false) String saleNumStart,
                         @RequestParam(value = "saleNumEnd", required = false) String saleNumEnd,
                         @RequestParam(value = "saleAmountStart", required = false) String saleAmountStart,
                         @RequestParam(value = "saleAmountEnd", required = false) String saleAmountEnd,
                         @RequestParam(value = "isRecommend", required = false) String isRecommend,
                         @RequestParam(value = "status", required = false) String status) {
        Map<String, Object> paramsMap = new HashMap<>(11);
        paramsMap.put("menuName", menuName);
        paramsMap.put("priceStart", StringUtils.isEmpty(priceStart) ? null : Integer.valueOf(priceStart));
        paramsMap.put("priceEnd", StringUtils.isEmpty(priceEnd) ? null : Integer.valueOf(priceEnd));
        paramsMap.put("isRecommend", StringUtils.isEmpty(isRecommend) ? null : Integer.valueOf(isRecommend));
        paramsMap.put("status", StringUtils.isEmpty(status) ? null : Boolean.valueOf(status));
        paramsMap.put("saleNumStart", StringUtils.isEmpty(saleNumStart) ? null : Integer.valueOf(saleNumStart));
        paramsMap.put("saleNumEnd", StringUtils.isEmpty(saleNumEnd) ? null : Integer.valueOf(saleNumEnd));
        paramsMap.put("saleAmountStart", StringUtils.isEmpty(saleAmountStart) ? null : Integer.valueOf(saleAmountStart));
        paramsMap.put("saleAmountEnd", StringUtils.isEmpty(saleAmountEnd) ? null : Integer.valueOf(saleAmountEnd));
        paramsMap.put("pageNum", pageNum);
        paramsMap.put("pageSize", pageSize);
        try {
            List<IngredientMenuBo> list = ingredientMenuService.queryDataByConditions(paramsMap);
            return Response.success(list, ((Page) list).getTotal(), pageSize, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 批量删除饮品
     *
     * @param menuIds 饮品编码数组
     * @return
     */
    @ApiOperation("批量删除饮品")
    @PostMapping(value = "deleteMulti")
    public Response deleteMulti(Long[] menuIds) {
        try {
            if (null == menuIds || menuIds.length < 1) {
                return Response.failure();
            }
            ingredientMenuService.deleteBatch(menuIds);
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 跳转到添加页面需要的初始数据
     *
     * @return
     */
    @ApiOperation("跳转到添加页面需要的初始数据")
    @PostMapping(value = "toAdd")
    public Response toAdd() {
        try {
            return Response.success(ingredientMenuService.queryInitDataForInsertMenu());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 跳转到编辑页面需要的初始数据
     *
     * @param menuId 饮品编码
     * @return
     */
    @ApiOperation("跳转到编辑页面需要的初始数据")
    @PostMapping(value = "toUpdate")
    public Response toUpdate(@RequestParam Long menuId) {
        try {
            return Response.success(ingredientMenuService.queryMenuDetailByMenuId(menuId));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

}
