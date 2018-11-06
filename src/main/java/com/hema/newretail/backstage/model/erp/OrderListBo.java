package com.hema.newretail.backstage.model.erp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName OrderListBo
 * @Description 订单列表
 * @Author ---CWZ
 * @Date 2018/11/1 15:13
 * @Version 1.0
 **/
public class OrderListBo {
    /**订单ID*/
    private Long id;

    /**订单编号*/
    private String orderCode;

    /**原料厂商名称*/
    private String manufacturerName;

    /**订单金额*/
    private BigDecimal contractPrice;

    /**0  订单状态 0待配送 1已配送*/
    private Integer orderStatus;

    /** 备注*/
    private String remark;

    /**创建时间*/
    private Date gmtCreate;

    private List<OrderListIngredientBo> ingredients;

    private List<OrderListAddressBo> addresses;

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
        this.orderCode = orderCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
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
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public List<OrderListIngredientBo> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<OrderListIngredientBo> ingredients) {
        this.ingredients = ingredients;
    }

    public List<OrderListAddressBo> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<OrderListAddressBo> addresses) {
        this.addresses = addresses;
    }
}
