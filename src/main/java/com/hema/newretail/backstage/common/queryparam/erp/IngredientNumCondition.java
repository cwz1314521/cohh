package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Department 新零售
 * @ClassName IngredientNumCondition
 * @Description 配料数量
 * @Author ---CWZ
 * @Date 2018/10/31 11:49
 * @Version 1.0
 **/
@ApiModel(value = "配料数量",description = "配料数量")
public class IngredientNumCondition {

    @ApiModelProperty(value = "原料ID")
    private Long ingredientId;

    @ApiModelProperty(value = "数量")
    private Integer num;

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
