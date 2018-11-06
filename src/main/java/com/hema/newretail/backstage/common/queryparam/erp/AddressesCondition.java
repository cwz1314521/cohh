package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName AddressesCondition
 * @Description 收货地址
 * @Author ---CWZ
 * @Date 2018/10/31 11:45
 * @Version 1.0
 **/
@ApiModel(value = "收货地址",description = "收货地址")
public class AddressesCondition {



    @ApiModelProperty(value = "分公司ID")
    private Long companyId;

    @ApiModelProperty(value = "送达时间")
    private String deliveryTime;

    @ApiModelProperty(value = "配料数量")
    private List<IngredientNumCondition> ingredientNum;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<IngredientNumCondition> getIngredientNum() {
        return ingredientNum;
    }

    public void setIngredientNum(List<IngredientNumCondition> ingredientNum) {
        this.ingredientNum = ingredientNum;
    }
}
