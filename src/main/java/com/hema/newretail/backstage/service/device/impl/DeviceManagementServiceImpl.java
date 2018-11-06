package com.hema.newretail.backstage.service.device.impl;

import com.hema.newretail.backstage.common.queryparam.device.*;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.service.device.DeviceManagementService;
import org.springframework.stereotype.Service;

/**
 * @Department 新零售
 * @ClassName DeviceManagementServiceImpl
 * @Description 设备管理 impl
 * @Author ---CWZ
 * @Date 2018/10/11 14:01
 * @Version 1.0
 **/
@Service
public class DeviceManagementServiceImpl implements DeviceManagementService {

    /**
     * 功能描述: 申请设备列表
     *
     * @param deviceApplyListCondition
     * @param: DeviceApplyListCondition
     * @return: list
     * @author: cwz
     * @date: 2018/10/11 14:24
     */
    @Override
    public Response deviceApplyList(DeviceApplyListCondition deviceApplyListCondition) {
        return null;
    }

    /**
     * 功能描述:新增申请设备
     *
     * @param addDeviceApplyCondition
     * @param: AddDeviceApplyCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 15:17
     */
    @Override
    public Response addDeviceApply(AddDeviceApplyCondition addDeviceApplyCondition) {
        return null;
    }

    /**
     * 功能描述:新增申请列表excel导出
     *
     * @param deviceApplyListCondition
     * @param: AddDeviceApplyCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 15:17
     */
    @Override
    public Response excel(DeviceApplyListCondition deviceApplyListCondition) throws Exception {
        return null;
    }

    /**
     * 功能描述: 设备合作列表----详情
     *
     * @param deviceCooperationListCondition
     * @param: DeviceCooperationListCondition
     * @return: cooperationList
     * @author: cwz
     * @date: 2018/10/11 15:54
     */
    @Override
    public Response cooperationList(DeviceCooperationListCondition deviceCooperationListCondition) {
        return null;
    }

    /**
     * 功能描述: 设备合作列表----excel导出
     *
     * @param deviceCooperationListCondition
     * @param: DeviceCooperationListCondition
     * @return: cooperationExcel
     * @author: cwz
     * @date: 2018/10/11 15:54
     */
    @Override
    public Response excelCooperation(DeviceCooperationListCondition deviceCooperationListCondition) {
        return null;
    }

    /**
     * 功能描述:申请设备列表----申请号查询
     *
     * @param queryCooperationCondition
     * @param: QueryCooperationCondition
     * @return: detail
     * @author: cwz
     * @date: 2018/10/11 16:27
     */
    @Override
    public Response queryCooperation(QueryCooperationCondition queryCooperationCondition) {
        return null;
    }

    /**
     * 功能描述:申请设备列表----申请号新增
     *
     * @param: QueryCooperationCondition
     * @return: success
     * @author: cwz
     * @date: 2018/10/11 16:27
     */
    public Response addCooperation(AddCooperationCondition addCooperationCondition) {
        return null;
    }
}
