package com.hema.newretail.backstage.model.menu;

import java.math.BigDecimal;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.menu
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 11:03
 */
public class MenuPropertiesBo {
    private Long id;
    private Long proType;
    private String typeName;
    private String proName;
    private BigDecimal price;
    private BigDecimal num;
    private Boolean status;
    private Long menuId;
    private Boolean isFrontShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProType() {
        return proType;
    }

    public void setProType(Long proType) {
        this.proType = proType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Boolean getFrontShow() {
        return isFrontShow;
    }

    public void setFrontShow(Boolean frontShow) {
        isFrontShow = frontShow;
    }
}
