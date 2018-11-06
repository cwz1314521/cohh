package com.hema.newretail.backstage.common.queryparam.agent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Department 新零售
 * @ClassName DeleteAgentCondition
 * @Description 代理公司删除参数类
 * @Author ---CWZ
 * @Date 2018/10/8 15:30
 * @Version 1.0
 **/
@ApiModel(description = "DeleteAgentCondition")
public class DeleteAgentCondition {

    @NotNull(message = "id不可为空")
    @ApiModelProperty(value = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
