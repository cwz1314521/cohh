package com.hema.newretail.backstage.model.menuproperties;

import java.math.BigDecimal;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.menuproperties
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-23 17:39
 */
public class MenuPropertisBo {
    private Long propertiesId;
    private String proName;
    private Long typeId;
    private BigDecimal price;
    private BigDecimal num;

    public Long getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(Long propertiesId) {
        this.propertiesId = propertiesId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
}
