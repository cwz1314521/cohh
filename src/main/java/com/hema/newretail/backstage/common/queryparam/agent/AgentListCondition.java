package com.hema.newretail.backstage.common.queryparam.agent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Department 新零售
 * @ClassName AgentListCondition
 * @Description agent  ---AgentController---   参数类
 * @Author ---CWZ
 * @Date 2018/9/25 9:22
 * @Version 1.0
 **/
@ApiModel(description = "AgentListCondition")
public class AgentListCondition {


    /**页码  默认为1*/
    @ApiModelProperty(value = "页码")
    @NotNull(message = "页码不可以为空")
    private Integer pageNum;

    /**每页最大数  默认为10*/
    @ApiModelProperty(value = "每页最大数")
    @NotNull(message = "每页最大数不可以为空")
    private Integer pageSize;

    /**名称或者编号*/
    @ApiModelProperty(value = "名称或者编号")
    private String name;

    /**省*/
    @ApiModelProperty(value = "省")
    private String province;

    /**市*/
    @ApiModelProperty(value = "市")
    private String city;

    /**多选区*/
    @ApiModelProperty(value = "多选区")
    private String areas;

    /**多选区数组*/
    @ApiModelProperty(value = "多选区数组")
    private String [] area;

    /**主键*/
    @ApiModelProperty(value = "主键")
    private Long id;

    /**状态 正常 or 冻结*/
    @ApiModelProperty(value = "状态 正常0 or 冻结1")
    private String status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String[] getArea() {
        return area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
