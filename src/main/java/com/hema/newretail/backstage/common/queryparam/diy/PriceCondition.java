package com.hema.newretail.backstage.common.queryparam.diy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Department 新零售
 * @ClassName NameCondition
 * @Description 列表独立模糊搜索信息
 * @Author ---CWZ
 * @Date 2018/10/18 10:58
 * @Version 1.0
 **/
@ApiModel(description = "PriceCondition")
public class PriceCondition {

    @ApiModelProperty(value = "新价格")
    @NotBlank(message = "新价格不可为空")
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
