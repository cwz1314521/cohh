package com.hema.newretail.backstage.common.queryparam.device;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Department 新零售
 * @ClassName AddDeviceApplySonCondition
 * @Description 新增申请设备------子参数类
 * @Author ---CWZ
 * @Date 2018/10/11 14:59
 * @Version 1.0
 **/
@ApiModel(description = "AddDeviceApplySonCondition")
public class AddDeviceApplySonCondition {

    /**省*/
    @ApiModelProperty(value = "省")
    private String province;

    /**城市*/
    @ApiModelProperty(value = "城市")
    private String city;

    /**区*/
    @ApiModelProperty(value = "区")
    private String area;

    /**具体地址*/
    @ApiModelProperty(value = "具体地址")
    private String addr;
    /**设备型号*/
    /**设备数量*/

}
