package com.hema.newretail.backstage.controller;

import com.alibaba.fastjson.JSONArray;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.model.index.IndexSaveParamBo;
import com.hema.newretail.backstage.service.IIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * hema-newetaril-com.hema.newretail.backstage.controller
 *
 * @author ZhangHaiSheng
 * @date 2018-08-20 16:35
 */
@Api(description = "首页接口")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IIndexService indexService;

    /**
     * 首页配置
     *
     * @return
     */
    @ApiOperation("首页配置")
    @PostMapping(value = "/config")
    public Response queryIndexConfig() {
        try {
            return Response.success(indexService.queryIndexConfig());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 查询所有模板
     *
     * @return
     */
    @ApiOperation("查询所有模板")
    @PostMapping(value = "/cssList")
    public Response queryCssList() {
        try {
            return Response.success(indexService.queryAllCss());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 保存首页布局
     *
     * @param paramBo
     * @return
     */
    @ApiOperation("保存首页布局")
    @PostMapping(value = "/cssSave")
    public Response cssSave(String paramBo) {
        try {
            List<IndexSaveParamBo> list = JSONArray.parseArray(paramBo, IndexSaveParamBo.class);
            indexService.insertIndexConfig(list);
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    /**
     * 查询首页模板内容类别
     *
     * @return
     */
    @ApiOperation("查询首页模板内容类别")
    @PostMapping(value = "/contentType")
    public Response contentType() {
        try {
            return Response.success(indexService.queryAllContentType());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("首页模板预览")
    @PostMapping(value = "/preview")
    public Response preview(String paramBo) {
        try {
            List<IndexSaveParamBo> list = JSONArray.parseArray(paramBo, IndexSaveParamBo.class);
            return Response.success(indexService.preview(list));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

}
