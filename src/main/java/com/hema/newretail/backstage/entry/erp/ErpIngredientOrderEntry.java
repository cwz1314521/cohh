package com.hema.newretail.backstage.entry.erp;

import java.math.BigDecimal;
import java.util.Date;

public class ErpIngredientOrderEntry {
    private Long id;

    private String orderCode;

    private Long ingredientManufacturerId;

    private BigDecimal contractPrice;

    private Integer orderStatus;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Long getIngredientManufacturerId() {
        return ingredientManufacturerId;
    }

    public void setIngredientManufacturerId(Long ingredientManufacturerId) {
        this.ingredientManufacturerId = ingredientManufacturerId;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "ErpIngredientOrderEntry{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", ingredientManufacturerId=" + ingredientManufacturerId +
                ", contractPrice=" + contractPrice +
                ", orderStatus=" + orderStatus +
                ", remark='" + remark + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}