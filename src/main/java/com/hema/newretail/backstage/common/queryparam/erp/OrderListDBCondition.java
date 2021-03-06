package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Department 新零售
 * @ClassName OrderListCondition
 * @Description 订单列表
 * @Author ---CWZ
 * @Date 2018/10/31 9:45
 * @Version 1.0
 **/
@ApiModel(value = "订单列表",description = "订单列表")
public class OrderListDBCondition {

    @ApiModelProperty(value = "订单编号")
    private String orderCode;

    @ApiModelProperty(value = "原料厂商ID")
    private Long manufacturerId;

    @ApiModelProperty(value = "分公司ID")
    private Long companyId;

    @ApiModelProperty(value = "配料ID")
    private Long ingredientId;

    @ApiModelProperty(value = "价格区间-开始价格")
    private BigDecimal startPrice;

    @ApiModelProperty(value = "价格区间-结束价格")
    private BigDecimal endPrice;

    @ApiModelProperty(value = "创建时间-开始时间")
    private Date startDate;

    @ApiModelProperty(value = "创建时间-结束时间")
    private Date endDate;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(BigDecimal endPrice) {
        this.endPrice = endPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
