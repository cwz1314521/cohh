package com.hema.newretail.backstage.common.queryparam.device;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName AddDeviceApplyCondition
 * @Description 新增申请设备------参数类
 * @Author ---CWZ
 * @Date 2018/10/11 14:54
 * @Version 1.0
 **/
@ApiModel(description = "AddDeviceApplyCondition")
public class AddDeviceApplyCondition {




    /**设备型号设备数量*/
    @ApiModelProperty(value = "设备型号设备数量")
    private List<AddDeviceApplySonCondition> list;

    /**保证金*/
    /**基础料*/
    /**设备运输费*/
    /**业务员*/
    /**业务员联系方式*/
    /**备注*/

}
