package com.hema.newretail.backstage.common.queryparam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Department 新零售
 * @ClassName CommomPageCondition
 * @Description pagenum pagesize
 * @Author ---CWZ
 * @Date 2018/10/29 15:00
 * @Version 1.0
 **/
@ApiModel(value = "分页公共类",description = "分页公共类")
public class CommomPageCondition {

    @ApiModelProperty(value = "页码")
    @NotNull(message = "页码不可为空")
    private Integer pageNum;

    @ApiModelProperty(value = "每页最大数")
    @NotNull(message = "每页最大数不可为空")
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
