package com.hema.newretail.backstage.common.queryparam.device;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Department 新零售
 * @ClassName QueryCooperationCondition
 * @Description 设备合作申请号查询
 * @Author ---CWZ
 * @Date 2018/10/11 16:25
 * @Version 1.0
 **/
@ApiModel(description = "QueryCooperationCondition")
public class AddCooperationCondition {
    @ApiModelProperty(value = "申请号")
    private String id;
    @ApiModelProperty(value = "实付")
    private BigDecimal money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
