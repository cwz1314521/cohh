package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.queryparam.BaseCompanyDeleteParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashInitMapParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashQueryParameter;
import com.hema.newretail.backstage.entry.BaseCompanyGeoHashData;

import java.util.List;
import java.util.Map;

/**
 * @Description: 分公司服务区域接口
 * @Author: Mr.Yang
 * @Date: 2018/09/26
 **/
public interface IBaseCompanyGeoHashService {
    int countByBaseCompanyId(Long id);
    List<BaseCompanyGeoHashData> findServiceAreaByBaseCompanyId(BaseCompanyDeleteParameter baseCompanyId);
    List<String> initMapGeoHash(BaseCompanyGeoHashInitMapParameter parameter);
    Map<String,List<String>> queryBaseCompanyGeoHash(BaseCompanyGeoHashQueryParameter parameter);
}
