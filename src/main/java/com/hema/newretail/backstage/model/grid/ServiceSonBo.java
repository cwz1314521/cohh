package com.hema.newretail.backstage.model.grid;

/**
 * @Department 新零售
 * @ClassName ServiceBo
 * @Description 服务网格列表返回
 * @Author ---CWZ
 * @Date 2018/10/13 14:00
 * @Version 1.0
 **/
public class ServiceSonBo {

    private String geoHashCode;

    private Double longitude;

    private Double latitude;

    public String getGeoHashCode() {
        return geoHashCode;
    }

    public void setGeoHashCode(String geoHashCode) {
        this.geoHashCode = geoHashCode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
