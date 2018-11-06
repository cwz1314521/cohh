package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.BaseTagEntryMapper;
import com.hema.newretail.backstage.entry.BaseTagEntry;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.UserManaCondition;
import com.hema.newretail.backstage.service.IUserManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 程文政
 * @Date: 2018/8/21 15:29
 * @Description:用户管理controller 数据操作---mongoDB
 * @Version: 1.0
 */
@Api(description = "≡(▔﹏▔)≡用户管理相关接口")
@Controller
@RequestMapping(value = "/user")
public class ManagementController {



    @Autowired
    private BaseTagEntryMapper baseTagEntryMapper;

    @Autowired
    private IUserManagementService userManagementService;

    /**
     *
     * 功能描述: 用户列表查询展示用户信息----mongoDB
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/21 15:35
     */
    @ApiOperation("用户列表查询展示用户信息")
    @PostMapping(value = "/findUserList")
    @ResponseBody
    public Response findUserList(@RequestBody UserManaCondition userManaCondition)throws  Exception{
        return userManagementService.paginationQuery(userManaCondition);
    }
    /**
     *
     * 功能描述: 查询所有的标签
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/21 15:35
     */
    @ApiOperation("查询所有的标签")
    @PostMapping(value = "/findAllTag")
    @ResponseBody
    public Response findAllTag(){
        List<BaseTagEntry> baseTagEntries = baseTagEntryMapper.selectNotDelete();
        return Response.success(baseTagEntries);
    }
    /**
     *
     * 功能描述: 批量冻结
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/21 15:35
     */
    @ApiOperation("批量冻结")
    @PostMapping(value = "/batchFreeze")
    @ResponseBody
    public Response userFreezeList(String ids){

        return  userManagementService.batchFreeze(ids);
    }
    /**
     *
     * 功能描述: 批量解冻
     *
     * @param:
     * @return:
     * @auther: cwz
     * @date: 2018/8/21 15:35
     */
    @ApiOperation("批量冻结")
    @PostMapping(value = "/batchRelease")
    @ResponseBody
    public Response userThawList(String ids){
        return  userManagementService.batchRelease(ids);
    }

}
