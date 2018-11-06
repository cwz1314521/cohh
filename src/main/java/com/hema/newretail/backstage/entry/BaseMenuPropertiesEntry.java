package com.hema.newretail.backstage.entry;

import java.math.BigDecimal;
import java.util.Date;

public class BaseMenuPropertiesEntry {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    private String proName;

    private Long proType;

    private Long menuId;

    private BigDecimal price;

    private BigDecimal num;

    private Boolean status;

    private Boolean isFrontShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Long getProType() {
        return proType;
    }

    public void setProType(Long proType) {
        this.proType = proType;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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

    public Boolean getIsFrontShow() {
        return isFrontShow;
    }

    public void setIsFrontShow(Boolean isFrontShow) {
        this.isFrontShow = isFrontShow;
    }
}