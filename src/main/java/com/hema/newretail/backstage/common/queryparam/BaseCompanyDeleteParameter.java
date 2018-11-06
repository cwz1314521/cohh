package com.hema.newretail.backstage.common.queryparam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Description: 删除分公司参数模型
 * @Author: Mr.Yang
 * @Date: 2018/10/09
 **/
@ApiModel(description = "BaseCompanyDeleteParameter")
public class BaseCompanyDeleteParameter {

    @NotNull(message = "id不可为空")
    @ApiModelProperty(value = "id")
    private Long id;

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }
}
