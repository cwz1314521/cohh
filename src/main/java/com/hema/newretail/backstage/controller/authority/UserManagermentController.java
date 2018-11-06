package com.hema.newretail.backstage.controller.authority;



import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseUserInfoEntry;
import com.hema.newretail.backstage.service.authority.IUserManagermentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 程文政
 * @Date: 2018/9/11 09:12
 * @Description:--------------------权限控制模块对于用户权限的管理模块controller
 * @Version: 1.0
 */
@Api(description = "≡(▔﹏▔)≡权限控制模块对于用户权限的管理模块")
@Controller
@RequestMapping(value = "/userManagerment")
public class UserManagermentController {

    /**注入----权限控制模块对于用户权限的管理模块service*/
    @Autowired
    private IUserManagermentService userManagermentService;

    /**
     *
     * 功能描述:展示用户管理的用户列表  分页进行展示
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "/list")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡用户列表，分页显示")
    public Response list(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        return userManagermentService.list(pageNum,pageSize);
    }


    /**
     *
     * 功能描述:添加用户----公司展示功能
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "/addCompany")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡添加用户---公司展示")
    public Response addCompany(){
        return userManagermentService.addCompany();
    }


    /**
     *
     * 功能描述:添加用户----岗位展示
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "addPost")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡添加用户----岗位展示")
    public Response addPost(){
        return userManagermentService.addPost();
    }


    /**
     *
     * 功能描述:添加用户----操作
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡添加用户----操作")
    public Response add(@RequestBody BaseUserInfoEntry entry){
        return userManagermentService.add(entry);
    }


    /**
     *
     * 功能描述:编辑用户---用户详情
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "/editDetail")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡编辑用户---用户详情")
    public Response editDetail(@RequestParam(required = true) Long id){
        return userManagermentService.editDetail(id);
    }


    /**
     *
     * 功能描述: 编辑用户---查询选定岗位的功能组
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "/editFunction")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡编辑用户---查询选定岗位的功能组")
    public Response editFunction(){
        return userManagermentService.editFunction();
    }


    /**
     *
     * 功能描述: 编辑用户----保存操作
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "/edit")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡编辑用户----保存操作")
    public Response edit(@RequestBody BaseUserInfoEntry entry){
        return userManagermentService.edit(entry);
    }


    /**
     *
     * 功能描述: 删除用户
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/11 9:18
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡删除用户")
    public Response delete(@RequestParam(required = true) Long id){
        return userManagermentService.delete(id);
    }

    /**
     *
     * 功能描述: 给岗位分配权限
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/12 9:03
     */
    @PostMapping(value = "/grant")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡岗位权限分配")
    public Response grant(@RequestParam(required = true) String funkGroupCodes,@RequestParam(required = true) Long postId){
        return userManagermentService.grant(funkGroupCodes,postId);
    }

    /**
     *
     * 功能描述: 所有权限列表
     *
     * @param:
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/12 9:03
     */
    @PostMapping(value = "/listPermission")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡所有权限列表")
    public Response listPermission(@RequestParam(required = true) Long postId){
        return userManagermentService.listPermission(postId);
    }

}
