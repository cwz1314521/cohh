package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName OrderAddCondition
 * @Description 订单添加
 * @Author ---CWZ
 * @Date 2018/10/31 11:38
 * @Version 1.0
 **/
@ApiModel(value = "订单添加",description = "订单添加")
public class OrderAddCondition {

    @ApiModelProperty(value = "原料厂商名称")
    private Long manufacturerId;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal contractPrice;

    @ApiModelProperty(value = "收货地址")
    private List<AddressesCondition> addresses;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public List<AddressesCondition> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesCondition> addresses) {
        this.addresses = addresses;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
