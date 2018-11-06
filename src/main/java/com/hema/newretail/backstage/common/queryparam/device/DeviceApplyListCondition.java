package com.hema.newretail.backstage.common.queryparam.device;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Department 新零售
 * @ClassName DeviceApplyListCondition
 * @Description 设备申请列表Condition
 * @Author ---CWZ
 * @Date 2018/10/11 14:12
 * @Version 1.0
 **/
@ApiModel(description = "DeviceApplyListCondition")
public class DeviceApplyListCondition {

//    /**申请单号*/
//    @ApiModelProperty(value = "申请单号")
//    /**代理人*/
//    @ApiModelProperty(value = "代理人")
//    /**省*/
//    @ApiModelProperty(value = "省")
//    /**市*/
//    @ApiModelProperty(value = "市")
//    /**区*/
//    @ApiModelProperty(value = "区")
//    /**申请时间pre*/
//    @ApiModelProperty(value = "申请时间pre")
//    /**申请时间*/
//    @ApiModelProperty(value = "申请时间")
//    /**业务员*/
//    @ApiModelProperty(value = "业务员")
    /**处理状态*/
    @ApiModelProperty(value = "处理状态")
    private String status;

}
