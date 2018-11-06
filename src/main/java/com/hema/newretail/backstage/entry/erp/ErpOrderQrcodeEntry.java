package com.hema.newretail.backstage.entry.erp;

import java.util.Date;

public class ErpOrderQrcodeEntry {
    private Long id;

    private Long orderIngredientId;

    private String qrcodeCode;

    private String qrcodeUrl;

    private Date gmtCreate;

    private Date qualityGuaranteePeriod;

    private Integer status;

    private Long companyId;

    private Long gridCompanyId;

    private Long machineId;

    private Long companyInstoreUserId;

    private Date companyInstoreTime;

    private Long companyOutstoreUserId;

    private Date companyOutstoreTime;

    private Long gridUserId;

    private Long gridInstoreUserId;

    private Date gridInstoreTime;

    private Long gridOutstoreUserId;

    private Date gridOutstoreTime;

    private Long gridTaskUserId;

    private Date upTime;

    private Date downTime;

    private Date discardedTime;

    private Long discardedUserId;

    private Date outFactoryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderIngredientId() {
        return orderIngredientId;
    }

    public void setOrderIngredientId(Long orderIngredientId) {
        this.orderIngredientId = orderIngredientId;
    }

    public String getQrcodeCode() {
        return qrcodeCode;
    }

    public void setQrcodeCode(String qrcodeCode) {
        this.qrcodeCode = qrcodeCode == null ? null : qrcodeCode.trim();
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl == null ? null : qrcodeUrl.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }

    public void setQualityGuaranteePeriod(Date qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getGridCompanyId() {
        return gridCompanyId;
    }

    public void setGridCompanyId(Long gridCompanyId) {
        this.gridCompanyId = gridCompanyId;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public Long getCompanyInstoreUserId() {
        return companyInstoreUserId;
    }

    public void setCompanyInstoreUserId(Long companyInstoreUserId) {
        this.companyInstoreUserId = companyInstoreUserId;
    }

    public Date getCompanyInstoreTime() {
        return companyInstoreTime;
    }

    public void setCompanyInstoreTime(Date companyInstoreTime) {
        this.companyInstoreTime = companyInstoreTime;
    }

    public Long getCompanyOutstoreUserId() {
        return companyOutstoreUserId;
    }

    public void setCompanyOutstoreUserId(Long companyOutstoreUserId) {
        this.companyOutstoreUserId = companyOutstoreUserId;
    }

    public Date getCompanyOutstoreTime() {
        return companyOutstoreTime;
    }

    public void setCompanyOutstoreTime(Date companyOutstoreTime) {
        this.companyOutstoreTime = companyOutstoreTime;
    }

    public Long getGridUserId() {
        return gridUserId;
    }

    public void setGridUserId(Long gridUserId) {
        this.gridUserId = gridUserId;
    }

    public Long getGridInstoreUserId() {
        return gridInstoreUserId;
    }

    public void setGridInstoreUserId(Long gridInstoreUserId) {
        this.gridInstoreUserId = gridInstoreUserId;
    }

    public Date getGridInstoreTime() {
        return gridInstoreTime;
    }

    public void setGridInstoreTime(Date gridInstoreTime) {
        this.gridInstoreTime = gridInstoreTime;
    }

    public Long getGridOutstoreUserId() {
        return gridOutstoreUserId;
    }

    public void setGridOutstoreUserId(Long gridOutstoreUserId) {
        this.gridOutstoreUserId = gridOutstoreUserId;
    }

    public Date getGridOutstoreTime() {
        return gridOutstoreTime;
    }

    public void setGridOutstoreTime(Date gridOutstoreTime) {
        this.gridOutstoreTime = gridOutstoreTime;
    }

    public Long getGridTaskUserId() {
        return gridTaskUserId;
    }

    public void setGridTaskUserId(Long gridTaskUserId) {
        this.gridTaskUserId = gridTaskUserId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getDiscardedTime() {
        return discardedTime;
    }

    public void setDiscardedTime(Date discardedTime) {
        this.discardedTime = discardedTime;
    }

    public Long getDiscardedUserId() {
        return discardedUserId;
    }

    public void setDiscardedUserId(Long discardedUserId) {
        this.discardedUserId = discardedUserId;
    }

    public Date getOutFactoryTime() {
        return outFactoryTime;
    }

    public void setOutFactoryTime(Date outFactoryTime) {
        this.outFactoryTime = outFactoryTime;
    }
}