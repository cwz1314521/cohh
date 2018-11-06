package com.hema.newretail.backstage.model.grid;

import org.apache.kafka.common.protocol.types.Field;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.model.grid
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-10-16 14:18
 */
public class GeoAndMachineNumBo {
    private String geoHashCode;
    private Integer num;

    public String getGeoHashCode() {
        return geoHashCode;
    }

    public void setGeoHashCode(String geoHashCode) {
        this.geoHashCode = geoHashCode;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
