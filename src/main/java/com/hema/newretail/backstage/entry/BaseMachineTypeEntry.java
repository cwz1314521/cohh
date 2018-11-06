package com.hema.newretail.backstage.entry;

import java.util.Date;

public class BaseMachineTypeEntry {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String machineTypeName;

    private String machineTypeCode;

    private Integer ingredientBoxNum;

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

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName == null ? null : machineTypeName.trim();
    }

    public String getMachineTypeCode() {
        return machineTypeCode;
    }

    public void setMachineTypeCode(String machineTypeCode) {
        this.machineTypeCode = machineTypeCode == null ? null : machineTypeCode.trim();
    }

    public Integer getIngredientBoxNum() {
        return ingredientBoxNum;
    }

    public void setIngredientBoxNum(Integer ingredientBoxNum) {
        this.ingredientBoxNum = ingredientBoxNum;
    }
}