package com.hema.newretail.backstage.common.queryparam.device;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Department 新零售
 * @ClassName QueryCooperationCondition
 * @Description 设备合作申请号查询
 * @Author ---CWZ
 * @Date 2018/10/11 16:25
 * @Version 1.0
 **/
@ApiModel(description = "QueryCooperationCondition")
public class QueryCooperationCondition {
    @ApiModelProperty(value = "申请号")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
