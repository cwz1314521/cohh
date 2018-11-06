package com.hema.newretail.backstage.model.zonebase;

import java.util.Date;
import java.util.List;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.zonebase
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 14:35
 */
public class ZoneMapGridBo {
    private Long zoneId;
    private String zoneName;
    private Integer machineNum;
    private List<ZoneHashcodesBo> hashcodes;

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

    public Integer getMachineNum() {
        return machineNum;
    }

    public void setMachineNum(Integer machineNum) {
        this.machineNum = machineNum;
    }

    public List<ZoneHashcodesBo> getHashcodes() {
        return hashcodes;
    }

    public void setHashcodes(List<ZoneHashcodesBo> hashcodes) {
        this.hashcodes = hashcodes;
    }
}
