package com.hema.newretail.backstage.model.zonebase;

import java.util.Date;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.zonebase
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 14:35
 */
public class ZoneBo {
    private Long zoneId;
    private String zoneName;
    private String province;
    private String city;
    private String area;
    private Long machineTypeId;
    private Integer machineNum;
    private Long boxGroupId;
    private String machineTypeName;

    private Date gmtModified;

    private String boxGroupName;

    public String getBoxGroupName() {
        return boxGroupName;
    }

    public void setBoxGroupName(String boxGroupName) {
        this.boxGroupName = boxGroupName;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Long machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public Integer getMachineNum() {
        return machineNum;
    }

    public void setMachineNum(Integer machineNum) {
        this.machineNum = machineNum;
    }

    public Long getBoxGroupId() {
        return boxGroupId;
    }

    public void setBoxGroupId(Long boxGroupId) {
        this.boxGroupId = boxGroupId;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
