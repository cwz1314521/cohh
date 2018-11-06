package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.model.tag.BaseTagEditBo;
import com.hema.newretail.backstage.service.ITagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: 程文政
 * @Date: 2018/8/17 17:43
 * @Description:
 * @Version: 1.0
 */
@Api(description = "≡(▔﹏▔)≡标签管理相关接口")
@Controller
@RequestMapping(value = "/tag")

public class TagController {

    @Autowired
    private ITagService tagService;

    private final static String TAGIDNOTNULL = "标签id不可以为空";


    /**
     *
     * 功能描述:后台管理系统标签模块选择饮品操作
     *
     * @param: null
     * @return: 全部饮品
     * @author: cwz
     * @date: 2018/8/20 14:37
     */
    @ApiOperation("全部饮品")
    @PostMapping(value = "/alldrink")
    @ResponseBody
    public Response allDrink(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10")Integer pageSize){
        return tagService.queryAllDrink(pageNum,pageSize);
    }
    /**
     *
     * 功能描述: 后台管理系统标签首页
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/8/20 16:48
     */
    @ApiOperation("全部标签")
    @PostMapping(value = "/findTag")
    @ResponseBody
    public Response tagIndex(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10")Integer pageSize){
        return tagService.tagJoint(pageNum,pageSize);
    }

    /**
     *
     * 功能描述: 组装参数类 先存tag表 轮存标签表
     *
     * @param:@RequestBody @Validated BaseTagEditBo baseTagEditBo,BindingResult bindingResult
     * @return:success or false
     * @auther: cwz
     * @date: 2018/8/21 13:51
     */
    @ApiOperation("添加标签")
    @PostMapping(value = "/addTag")
    @ResponseBody
    public Response tagAdd(@RequestBody @Validated BaseTagEditBo baseTagEditBo,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
                return tagService.tagAdd(baseTagEditBo);
        }
    }
    /**
     *
     * 功能描述: 根据tagId进行查询并返回单条数据
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/21 13:49
     */
    @ApiOperation("更新数据操作---详情")
    @PostMapping(value = "/findOneTag")
    @ResponseBody
    public Response tagShow(Long tagId){
        if(tagId == null){
            return Response.failure(TAGIDNOTNULL);
        }else {
            return Response.success(tagService.queryOneTag(tagId));
        }
    }

    /**
     *
     * 功能描述: 根据tagId进行 tag表的更新  然后根据tagId进行删除标签表信息  后存入新的标签信息
     *
     * @param: BaseTagEditBo
     * @return: success
     * @auther: cwz
     * @date: 2018/8/21 13:46
     */
    @ApiOperation("更新数据操作")
    @PostMapping(value = "/updateTag")
    @ResponseBody
    public Response updateTag(@RequestBody BaseTagEditBo baseTagEditBo){
        if(baseTagEditBo.getTagId()== null){
            return Response.failure(TAGIDNOTNULL);
        }else {
            return  tagService.tagEdit(baseTagEditBo);
        }
    }
    /**
     *
     * 功能描述:根据tagId删除相应的内容----------------------------逻辑删除
     *
     * @param: 标签Id
     * @return: success
     * @auther: cwz
     * @date: 2018/8/21 13:45
     */
    @ApiOperation("删除标签")
    @PostMapping(value = "/deleteTag")
    @ResponseBody
    public Response tagEdit(Long tagId){
        if(tagId == null){
            return Response.failure(TAGIDNOTNULL);
        }else {
            return tagService.tagDelete(tagId);
        }

    }

}
