package com.hema.newretail.backstage.controller.grid;

import com.github.pagehelper.Page;
import com.hema.newretail.CloudBohhApplication;
import com.hema.newretail.backstage.common.queryparam.grid.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.model.grid.GridCompanyListBo;
import com.hema.newretail.backstage.model.grid.SubCompanyBo;
import com.hema.newretail.backstage.service.grid.GridService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName GridController
 * @Description 网格公司管理controller
 * @Author ---CWZ
 * @Date 2018/9/21 13:25
 * @Version 1.0
 **/
@Api(description = "≡(▔﹏▔)≡网格公司管理相关接口")
@RestController
@RequestMapping("/grid")
public class GridController {


    @Autowired
    private GridService gridService;

    private static final Logger logger = LoggerFactory.getLogger(CloudBohhApplication.class);

    /**
     * 功能描述: 网格公司列表，分页显示
     *
     * @param: pageNum ：页数，pageSize ：每页最大数，name ：名称，province ：省，city ：市，area ：区，status ：状态
     * @return:
     * @author: cwz
     * @date: 2018/9/21 16:09
     */
    @PostMapping(value = "/list")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡网格公司列表，分页显示")
    public Response list(@RequestBody @Validated GridListCondition gridListCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("参数校验失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.list(gridListCondition);
        }
    }


    /**
     * 功能描述:添加网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡添加网格公司")
    public Response add(@RequestBody @Validated GridAddCondition gridAddCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("参数校验失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
                return gridService.addGrid(gridAddCondition);
        }
    }


    /**
     * 功能描述:修改网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/edit")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡修改网格公司")
    public Response edit(@RequestBody @Validated GridEditCondition gridEditCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("参数校验失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
                return gridService.editGrid(gridEditCondition);
        }
    }

    /**
     * 功能描述:修改网格公司详情
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/editDetail")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡修改网格公司详情")
    public Response editDetail(@RequestBody @Validated GridDeleteCondition gridDeleteCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("参数校验失败......"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.editGridDetail(gridDeleteCondition.getId());
        }
    }

    /**
     * 功能描述:重置密码
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/password")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡重置密码")
    public Response password(@RequestBody @Validated GridDeleteCondition gridDeleteCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("参数校验错误"+bindingResult.getFieldError().getDefaultMessage());
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.updatePassword(gridDeleteCondition.getId());
        }
    }

    /**
     * 功能描述:删除网格公司
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡删除网格公司")
    public Response delete(@RequestBody @Validated GridDeleteCondition gridDeleteCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.delete(gridDeleteCondition.getId());
        }
    }


    /**
     * 功能描述:积分管理
     *
     * @param: id ：主键，
     * type ：操作类型，
     * reason ：操作原因，
     * integral ：积分，
     * remark ：备注
     * @return: success
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/integral")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡积分管理")
    public Response integral(@RequestBody @Validated GridIntegralCondition gridIntegralCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.integral(gridIntegralCondition);
        }
    }


    /**
     * 功能描述:积分记录
     *
     * @param: id
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/integralRecord")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡积分记录")
    public Response integralRecord(@RequestBody @Validated GridIntegralRecordCondition gridIntegralRecordCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.integralRecord(gridIntegralRecordCondition);
        }
    }


    /**
     * 功能描述:服务网格
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/serviceEdit")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡服务网格修改保存")
    @Transactional(rollbackFor = Exception.class)
    public Response serviceEdit(@RequestBody @Validated ServiceCondition serviceCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            try {
                return gridService.serviceEdit(serviceCondition);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.failure(e.getMessage());
            }
        }
    }


    /**
     * 功能描述:服务网格
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/service")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡服务网格展示")
    public Response service(@RequestBody @Validated GridDeleteCondition gridDeleteCondition, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.service(gridDeleteCondition);
        }
    }



    /**
     * 功能描述:网格任务列表，分页显示
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/listTask")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡网格任务列表，分页显示")
    public Response listTask(@RequestBody @Validated GridListTaskCondition gridListTaskCondition, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.listTask(gridListTaskCondition);
        }
    }

    /**
     * 功能描述:网格任务修改详情
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/detailTask")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡网格任务列表，分页显示")
    public Response detailTask(@RequestBody @Validated GridDeleteCondition gridDeleteCondition, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.detailTask(gridDeleteCondition.getId());
        }
    }


    /**
     * 功能描述:绩效模式列表
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/listPref")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡绩效模式列表")
    public Response listPref() {
        return gridService.listPref();
    }


    /**
     * 功能描述:绩效添加
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/addPref")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡绩效添加")
    public Response addPref(@RequestBody @Validated GridPrefCondition gridPrefCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.addPref(gridPrefCondition);
        }
    }


    /**
     * 功能描述:绩效更改
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/editPref")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡绩效更改")
    public Response editPref(@RequestBody @Validated GridPrefEditCondition gridPrefEditCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.editPref(gridPrefEditCondition);
        }
    }


    /**
     * 功能描述:绩效模式删除
     *
     * @param:
     * @return:
     * @author: cwz
     * @date: 2018/9/21 9:31
     */
    @PostMapping(value = "/deletePref")
    @ResponseBody
    @ApiOperation("≡(▔﹏▔)≡绩效模式删除")
    public Response deletePref(@Validated @RequestBody GridDeleteCondition gridDeleteCondition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return gridService.deletePref(gridDeleteCondition.getId());
        }
    }

    @ApiOperation("查询所有子公司")
    @PostMapping(value = "/subCompanys")
    public Response subCompanys(@RequestBody SubCompanyCondition condition) {
        try {
            List<SubCompanyBo> list = gridService.subCompanys(condition.getNameOrCode(), condition.getPageNum(), condition.getPageSize());
            return Response.success(list, ((Page) list).getTotal(), condition.getPageSize(), condition.getPageNum());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("地图模式查看-查询网格公司")
    @PostMapping(value = "/gridCompanyList")
    public Response gridCompanyList(@RequestBody @Validated LookMapGridCompanyListCondition condition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            List<GridCompanyListBo> list = gridService.queryGridCompanyList(condition);
            return Response.success(list, ((Page) list).getTotal(), condition.getPageSize(), condition.getPageNum());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }

    @ApiOperation("地图模式查看")
    @PostMapping(value = "/lookMap")
    public Response lookMap(@RequestBody @Validated LookMapCondition condition, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("");
            return Response.failure(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            return Response.success(gridService.queryHashcodeByCompanyId(condition));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure();
        }
    }
}
