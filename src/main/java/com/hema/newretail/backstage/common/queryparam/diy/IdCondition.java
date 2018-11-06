package com.hema.newretail.backstage.common.queryparam.diy;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Department 新零售
 * @ClassName IdCondition
 * @Description diy系列id参数类---notnull
 * @Author ---CWZ
 * @Date 2018/10/18 9:54
 * @Version 1.0
 **/
@ApiModel(description = "IdCondition")
public class IdCondition {

    @ApiModelProperty(value = "ID")
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
