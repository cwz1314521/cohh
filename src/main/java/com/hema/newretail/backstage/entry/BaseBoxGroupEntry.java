package com.hema.newretail.backstage.entry;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class BaseBoxGroupEntry {

    //主键
    @NotNull(message = "主键不能为空")
    private Long id;

    //名字
    private String name;

    //描述
    private String desc;

    //修改时间
    private Date gmtModified;

    //创建时间
    private Date gmtCreate;

    //0 正常 1 删除
    private Boolean isDeleted;

    //机器类型
    private Long machineTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Long machineTypeId) {
        this.machineTypeId = machineTypeId;
    }
}