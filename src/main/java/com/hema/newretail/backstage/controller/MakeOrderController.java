package com.hema.newretail.backstage.controller;

import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.CentralBillListCondition;
import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.MakeOrderCondition;
import com.hema.newretail.backstage.service.IMakeOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 程文政
 * @Date: 2018/8/23 11:49
 * @Description: 订单制作controller
 * @Version: 1.0
 */
@Api(description = "≡(▔﹏▔)≡订单制作相关接口  or  订单中心相关接口")
@Controller
@RequestMapping(value = "/makeOrder")
public class MakeOrderController {

    @Autowired
    private IMakeOrderService makeOrderService;
    /**
     *
     * 功能描述: 显示全部网格公司供条件查询选取
     *
     * @param: null
     * @return: 网格公司all
     * @auther: cwz
     * @date: 2018/8/23 11:52
     */
    @PostMapping(value = "/gridCompany")
    @ApiOperation("显示全部网格公司供条件查询选取")
    @ResponseBody
    public Response gridCompany(){
        return makeOrderService.gridCompany();
    }


    /**
     *
     * 功能描述: 显示全部代理公司供条件查询选取
     *
     * @param: null
     * @return: 代理公司all
     * @auther: cwz
     * @date: 2018/8/23 11:52
     */
    @PostMapping(value = "/agentCompany")
    @ApiOperation("显示全部代理公司供条件查询选取")
    @ResponseBody
    public Response agentCompany(){
        return makeOrderService.agentCompany();
    }

    /**
     *
     * 功能描述:制作订单获取
     *
     * @param: MakeOrderCondition
     * @return: list
     * @auther: cwz
     * @date: 2018/8/23 14:40
     */
    @PostMapping(value = "/makeOrderList")
    @ApiOperation("订单列表")
    @ResponseBody
    public Response makeOrderList(@RequestBody MakeOrderCondition makeOrderCondition) throws Exception{
        return makeOrderService.pageOrders(makeOrderCondition);
    }

    /**
     *
     * 功能描述:保存bill备注信息
     *
     * @param: string
     * @return: success
     * @auther: cwz
     * @date: 2018/8/23 14:40
     */
    @PostMapping(value = "/saveBillRemark")
    @ApiOperation("保存bill备注信息")
    @ResponseBody
    public Response saveBillRemark(@RequestParam(required = true) String id,@RequestParam(required = true) String remark){
        return  makeOrderService.saveRemark(id,remark);
    }

    /**
     *
     * 功能描述:保存order备注信息
     *
     * @param: string
     * @return: success
     * @auther: cwz
     * @date: 2018/8/23 14:40
     */
    @PostMapping(value = "/saveOrderRemark")
    @ApiOperation("保存order备注信息")
    @ResponseBody
    public Response saveOrderRemark(@RequestParam(required = true) String id,@RequestParam(required = true) String remark){
        return  makeOrderService.saveOrderRemark(id,remark);
    }

    /**
     *
     * 功能描述:订单详情接口
     *
     * @param: string id
     * @return: 订单详情
     * @auther: cwz
     * @date: 2018/8/23 14:40
     */
    @PostMapping(value = "/orderDetail")
    @ApiOperation("订单详情接口")
    @ResponseBody
    public Response orderDetail(String id){
        return  makeOrderService.orderDetail(id);
    }

    /**
     *
     * 功能描述:账单详情接口
     *
     * @param: string
     * @return: 账单详情
     * @auther: cwz
     * @date: 2018/8/23 14:40
     */
    @PostMapping(value = "/billDetail")
    @ApiOperation("账单详情接口")
    @ResponseBody
    public Response billDetail(String id){
        return  makeOrderService.billDetail(id);
    }

    /**
     *
     * 功能描述:账单列表接口
     *
     * @param: string
     * @return: 账单详情
     * @auther: cwz
     * @date: 2018/8/23 14:40
     */
    @PostMapping(value = "/centralBillList")
    @ApiOperation("账单列表接口")
    @ResponseBody
    public Response centralBillList(@RequestBody CentralBillListCondition centralBillListCondition)throws Exception{
        return  makeOrderService.centralBillList(centralBillListCondition);
    }


    /**
     *
     * 功能描述:excel导出  账单
     *
     * @param: string
     * @return: 账单详情
     * @auther: cwz
     * @date: 2018/8/28 14:40
     */
    @GetMapping(value = "/billExcel")
    @ApiOperation("excel导出  账单")
    @ResponseBody
    public Response excel(HttpServletRequest request, HttpServletResponse response,  CentralBillListCondition centralBillListCondition)throws Exception{
//    public Response excel(HttpServletRequest request, HttpServletResponse response, @RequestBody CentralBillListCondition centralBillListCondition)throws Exception{


        return  makeOrderService.excle(request,response,centralBillListCondition);

    }

    /**
     *
     * 功能描述:excel导出  订单
     *
     * @param: string
     * @return: 账单详情
     * @auther: cwz
     * @date: 2018/8/28 14:40
     */
    @PostMapping(value = "/orderExcel")
    @ApiOperation("excel导出  订单")
    @ResponseBody
    public Response orderExcel(HttpServletRequest request, HttpServletResponse response, @RequestBody CentralBillListCondition centralBillListCondition)throws Exception{
        return  null;
    }
}
