package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Department 新零售
 * @ClassName ListManufacturerCondition
 * @Description 列表-查询原料厂商参数类
 * @Author ---CWZ
 * @Date 2018/10/31 17:01
 * @Version 1.0
 **/
@ApiModel(value = "列表-查询原料厂商参数类",description = "列表-查询原料厂商参数类")
public class ListManufacturerCondition {

    @ApiModelProperty(value = "原料厂商名称")
    private String companyName;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "每页最大数")
    private Integer pageSize;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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
