package com.hema.newretail.backstage.model.zonebase;

import java.util.Date;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.zonebase
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 17:51
 */
public class BoxGroupBo {
    private Long groupId;
    private String groupName;
    private String description;
    private Date gmtModified;
    private Long machineTypeId;
    private Long zoneId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Long machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
