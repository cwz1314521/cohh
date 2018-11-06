package com.hema.newretail.backstage.service.device;

import com.hema.newretail.backstage.common.queryparam.device.*;
import com.hema.newretail.backstage.common.utils.Response;

/**
 * @Department 新零售
 * @ClassName DeviceManagementService
 * @Description 设备模块    service
 * @Author ---CWZ
 * @Date 2018/10/11 14:01
 * @Version 1.0
 **/
public interface DeviceManagementService {


    /**
     *
     * 功能描述: 申请设备列表
     *
     * @param: DeviceApplyListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/11 14:24
     */
    Response deviceApplyList(DeviceApplyListCondition deviceApplyListCondition);

    /**
     *
     * 功能描述:新增申请设备
     *
     * @param: AddDeviceApplyCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 15:17
     */
    Response addDeviceApply(AddDeviceApplyCondition addDeviceApplyCondition);


    /**
     *
     * 功能描述:新增申请列表excel导出
     *
     * @param: AddDeviceApplyCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 15:17
     */
    Response excel(DeviceApplyListCondition deviceApplyListCondition)throws Exception;

    /**
     *
     * 功能描述: 设备合作列表----详情
     *
     * @param: DeviceCooperationListCondition
     * @return: cooperationList
     * @author: cwz
     * @date: 2018/10/11 15:54
     */
    Response cooperationList(DeviceCooperationListCondition deviceCooperationListCondition);

    /**
     *
     * 功能描述: 设备合作列表----excel导出
     *
     * @param: DeviceCooperationListCondition
     * @return: cooperationExcel
     * @author: cwz
     * @date: 2018/10/11 15:54
     */
    Response excelCooperation(DeviceCooperationListCondition deviceCooperationListCondition);

    /**
     *
     * 功能描述:申请设备列表----申请号查询
     *
     * @param: QueryCooperationCondition
     * @return: detail
     * @author: cwz
     * @date: 2018/10/11 16:27
     */
    Response queryCooperation(QueryCooperationCondition queryCooperationCondition);

    /**
     * 功能描述:申请设备列表----申请号新增
     *
     * @param: QueryCooperationCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 16:27
     */
    public Response addCooperation(AddCooperationCondition addCooperationCondition);
}
