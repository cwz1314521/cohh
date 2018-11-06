package com.hema.newretail.backstage.entry;

import java.util.Date;

public class BaseFuncGroup {
    private Long id;

    private String funcGroupCode;

    private String funcGroupName;

    private String moudleCode;

    private String moudleName;

    private String funcCode;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncGroupCode() {
        return funcGroupCode;
    }

    public void setFuncGroupCode(String funcGroupCode) {
        this.funcGroupCode = funcGroupCode == null ? null : funcGroupCode.trim();
    }

    public String getFuncGroupName() {
        return funcGroupName;
    }

    public void setFuncGroupName(String funcGroupName) {
        this.funcGroupName = funcGroupName == null ? null : funcGroupName.trim();
    }

    public String getMoudleCode() {
        return moudleCode;
    }

    public void setMoudleCode(String moudleCode) {
        this.moudleCode = moudleCode == null ? null : moudleCode.trim();
    }

    public String getMoudleName() {
        return moudleName;
    }

    public void setMoudleName(String moudleName) {
        this.moudleName = moudleName == null ? null : moudleName.trim();
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode == null ? null : funcCode.trim();
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}