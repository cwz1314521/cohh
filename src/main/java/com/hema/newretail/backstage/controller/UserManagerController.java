package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.UserManaCondition;
import com.hema.newretail.backstage.common.utils.ExcelUtils;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.utils.TimeUtil;
import com.hema.newretail.backstage.entry.UserManagerData;
import com.hema.newretail.backstage.entry.PushInfoData;
import com.hema.newretail.backstage.entry.UserFormIdData;
import com.hema.newretail.backstage.service.IUserManagerService;
import com.hema.newretail.backstage.service.IUserPushInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;

/**
 * 用户管理Controller
 */
@RestController
@RequestMapping(value = "/userManager")
public class UserManagerController {

    @Autowired
    private IUserManagerService userManagerService;

    @Autowired
    private IUserPushInfoService userPushInfoService;

    @Value(value = "${excelModel.srcFileName}")
    private String srcFileName;

    private static final String COMMA  = ",";

    /**
     * 会员详情接口
     * @param id
     * @return
     */
    @ApiOperation(value = "会员详情接口")
    @RequestMapping(value = "/userComsumptionDetail",method = RequestMethod.POST)
    @ResponseBody
    public Response queryUserConsumptionDetail(String id){
        UserManagerData user = userManagerService.queryOneById(id);

        return Response.success(user);
    }

    /**
     * 根据id更新会员账号状态
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id更新会员账号状态")
    @RequestMapping(value = "/updateUserStatusById",method = RequestMethod.POST)
    @ResponseBody
    public Response updateUserStatusById(String id){
        if(userManagerService.updateStatusById(id)){
            return Response.success();
        }else {
            return Response.failure();
        }
    }

    /**
     * 会员注销接口
     * @param id
     * @return
     */
    @ApiOperation(value = "会员注销接口")
    @RequestMapping(value = "/logoutUser",method = RequestMethod.POST)
    @ResponseBody
    public Response logoutUser(String id){
        return Response.success();
    }

    /**
     * 会员消费记录接口
     * @param params{openId:String,pageNum:int,pageSize:int}都是必填项
     * @return
     */
    @ApiOperation(value = "会员消费记录接口")
    @RequestMapping(value = "/userConsumptions",method = RequestMethod.POST)
    @ResponseBody
    public Response userConsumptionsByOpenId(@RequestBody Map<String,Object> params){

        return userManagerService.getUserConsumptionsByOpenId(params);
    }

    /**
     * 推送信息列表接口
     * @param params{pageNum:int,pageSize:int}都是必填项
     * @return
     */
    @ApiOperation(value = "推送信息列表接口")
    @PostMapping(value = "/pushInfoAll")
    @ResponseBody
    public Response getUserPushInfoAll(@RequestBody Map<String,Object> params){
        return userPushInfoService.findAll(params);
    }

    /**
     * 推送信息详情接口
     * @param id
     * @return
     */
    @ApiOperation(value = "推送信息详情接口")
    @PostMapping(value = "/pushInfoById")
    @ResponseBody
    public Response getUserPushInfoById(@RequestBody String id){
        return Response.success(userPushInfoService.findOne(id));
    }

    /**
     * 推送信息保存接口
     * @param data
     */
    @ApiOperation(value = "推送信息保存接口")
    @PostMapping(value = "/pushInfoToUser")
    @ResponseBody
    public void pushInfoToUser(@RequestBody PushInfoData data){
        userPushInfoService.save(data);
    }

    /**
     * 保存formId测试接口
     * @param data
     */
    @ApiOperation(value = "保存前端formId接口")
    @PostMapping(value = "/saveUserFormId")
    @ResponseBody
    public void saveUserFormId(@RequestBody UserFormIdData data){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_WEEK,-7);
        Date beginTime = c.getTime();
        data.setCreateTime(beginTime);
        userPushInfoService.saveFormId(data);
    }

    /**
     * 导出会员信息Excel接口
     * @param userManaCondition
     * @param response
     * @throws Exception
     */
    @ApiOperation(value = "导出会员信息Excel接口",produces="application/octet-stream")
    @GetMapping(value = "/exportUserInfoExcel")
    @ResponseBody
    public Response downUserManagerExcel(UserManaCondition userManaCondition, HttpServletResponse response) throws Exception {

        List<UserManagerData> userData = userManagerService.findAll(userManaCondition);

//        response.setContentType("application/octet-stream");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");

        String fileName = "用户数据导出"+ TimeUtil.getStringByDateFormart(new Date(),"yyyyMMddHHmmss")+".xlsx";
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        ExcelUtils.exportExcel(srcFileName,userData,response.getOutputStream());
        return Response.success();
    }

    /**
     * 发送推送消息，并保存推送信息
     * @param reqMap 包含users，title,content 其中users由用户信息id组合中间用“，”隔开
     * @return
     */
    @ApiOperation(value = "发送推送消息，并保存推送信息")
    @PostMapping(value = "/pushInfoToUsers")
    @ResponseBody
    public Response pushInfoToUsers(@RequestBody Map<String,String> reqMap){
        if(reqMap.size()>0){
            String users = reqMap.get("users");
            String title = reqMap.get("title");
            String content = reqMap.get("content");
            String[] idArr;
            if (users.indexOf(COMMA)>0){
                idArr = users.split(",");
            }else{
                idArr = new String[]{users};
            }

            //Todo 获取当前登录的用户
            String operator = "admin";

            //组装信息保存
            PushInfoData pushInfoData = new PushInfoData();
            pushInfoData.setContent(content);
            pushInfoData.setTitle(title);
            pushInfoData.setOperator(operator);
            pushInfoData.setUsers(Arrays.asList(idArr));
            pushInfoData.setPushTime(new Date());
            userPushInfoService.save(pushInfoData);
            return Response.success();
        }else {
            return Response.failure("参数不能为空");
        }

    }

}
