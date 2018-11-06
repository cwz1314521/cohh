package com.hema.newretail.backstage.common.queryparam.diy;

import com.hema.newretail.backstage.common.queryparam.usermanagementparameter.MakeOrderCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Department 新零售
 * @ClassName NameCondition
 * @Description 列表独立模糊搜索信息
 * @Author ---CWZ
 * @Date 2018/10/18 10:58
 * @Version 1.0
 **/
@ApiModel(description = "NameCondition")
public class NameCondition {

    @ApiModelProperty(value = "列表独立模糊搜索信息")
    private String message;

    @ApiModelProperty(value = "页码")
    @NotNull(message = "页码不可为空")
    private Integer pageSize;

    @NotNull(message = "每页最大数不可为空")
    @ApiModelProperty(value = "每页最大数")
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
