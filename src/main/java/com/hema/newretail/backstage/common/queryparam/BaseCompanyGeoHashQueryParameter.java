package com.hema.newretail.backstage.common.queryparam;

import java.util.List;

/**
 * @Description: 分公司网格地图初始化参数实体类
 * @Author: Mr.Yang
 * @Date: 2018/10/12
 **/
public class BaseCompanyGeoHashQueryParameter {
    private List<String> MapGeoHash;
    private Long baseCompanyId;

    public List<String> getMapGeoHash() {
        return MapGeoHash;
    }

    public void setMapGeoHash(List<String> mapGeoHash) {
        MapGeoHash = mapGeoHash;
    }

    public Long getBaseCompanyId() {
        return baseCompanyId;
    }

    public void setBaseCompanyId(Long baseCompanyId) {
        this.baseCompanyId = baseCompanyId;
    }
}
