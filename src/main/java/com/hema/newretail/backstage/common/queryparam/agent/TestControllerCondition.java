package com.hema.newretail.backstage.common.queryparam.agent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @Department 新零售
 * @ClassName TestControllerCondition
 * @Description TODO
 * @Author ---CWZ
 * @Date 2018/10/22 15:59
 * @Version 1.0
 **/
@ApiModel(description = "TestControllerCondition")
public class TestControllerCondition {




    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @ApiModelProperty(value = "每分对应金额")
    @NotNull(message = "每分对应金额不可为空")
    private BigDecimal tel;

    public BigDecimal getTel() {
        return tel;
    }

    public void setTel(BigDecimal tel) {
        this.tel = tel;
    }
}
