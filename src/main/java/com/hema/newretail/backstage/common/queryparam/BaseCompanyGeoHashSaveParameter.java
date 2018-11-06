package com.hema.newretail.backstage.common.queryparam;

import java.util.List;

/**
 * @Description: 分公司网格管理保存参数实体类
 * @Author: Mr.Yang
 * @Date: 2018/10/13
 **/
public class BaseCompanyGeoHashSaveParameter {
    private List<String> baseCompanyGeoHash;
    private Long baseCompanyId;

    public List<String> getBaseCompanyGeoHash() {
        return baseCompanyGeoHash;
    }

    public void setBaseCompanyGeoHash(List<String> baseCompanyGeoHash) {
        this.baseCompanyGeoHash = baseCompanyGeoHash;
    }

    public Long getBaseCompanyId() {
        return baseCompanyId;
    }

    public void setBaseCompanyId(Long baseCompanyId) {
        this.baseCompanyId = baseCompanyId;
    }
}
