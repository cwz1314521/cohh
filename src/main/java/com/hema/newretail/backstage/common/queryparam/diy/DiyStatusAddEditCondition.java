package com.hema.newretail.backstage.common.queryparam.diy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName DiyStatusAddEditCondition
 * @Description Diy添加修改
 * @Author ---CWZ
 * @Date 2018/9/27 16:09
 * @Version 1.0
 **/
@ApiModel(description = "DiyStatusAddEditCondition")
public class DiyStatusAddEditCondition {

    @ApiModelProperty(value = "ID")
    private  Long id;

    @ApiModelProperty(value = "最小值")
    @NotNull(message = "最小值不可为空")
    private Integer ingredientsVolumeMin;

    @NotNull(message = "最大值不可为空")
    @ApiModelProperty(value = "最大值")
    private Integer ingredientsVolumeMax;

    @ApiModelProperty(value = "描述")
    @NotNull(message = "描述不可为空")
    private String stateDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIngredientsVolumeMin() {
        return ingredientsVolumeMin;
    }

    public void setIngredientsVolumeMin(Integer ingredientsVolumeMin) {
        this.ingredientsVolumeMin = ingredientsVolumeMin;
    }

    public Integer getIngredientsVolumeMax() {
        return ingredientsVolumeMax;
    }

    public void setIngredientsVolumeMax(Integer ingredientsVolumeMax) {
        this.ingredientsVolumeMax = ingredientsVolumeMax;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }
}
