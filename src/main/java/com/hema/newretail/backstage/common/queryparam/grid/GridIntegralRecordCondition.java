package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Department 新零售
 * @ClassName GridIntegralRecordCondition
 * @Description GridController ---  参数类
 * @Author ---CWZ
 * @Date 2018/9/26 11:09
 * @Version 1.0
 **/
@ApiModel(value = "GridIntegralRecordCondition")
public class GridIntegralRecordCondition {

    /**
     * 页码  默认为1
     */
    @NotNull(message = "页码不可以为空")
    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    /**
     * 每页最大数  默认为10
     */
    @NotNull(message = "每页最大数不可以为空")
    @ApiModelProperty(value = "每页最大数")
    private Integer pageSize;

    @NotNull(message = "网格公司不可以为空")
    @ApiModelProperty(value = "网格公司")
    private Long gridCompanyId;

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

    public Long getGridCompanyId() {
        return gridCompanyId;
    }

    public void setGridCompanyId(Long gridCompanyId) {
        this.gridCompanyId = gridCompanyId;
    }
}
