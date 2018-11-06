package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.common.queryparam.grid
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-10-17 18:00
 */
public class SubCompanyCondition {

    /**
     * 页码  默认为1
     */
    @NotNull(message = "页码不可以为空")
    private Integer pageNum;

    /**
     * 每页最大数  默认为10
     */
    @NotNull(message = "每页最大数不可以为空")
    private Integer pageSize;

    private String nameOrCode;

    @NotNull
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(@NotNull Integer pageNum) {
        this.pageNum = pageNum;
    }

    @NotNull
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(@NotNull Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }
}
