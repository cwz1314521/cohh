package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashSaveParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyNameParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyNameQueryParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyQueryParameter;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.entry.BaseCompanyData;

import java.util.List;
import java.util.Map;

/**
 *
 * @Description: 分公司管理服务接口
 *
 * @Author: Mr.Yang
 *
 **/
public interface IBaseCompanyService {

    int saveBaseCompany(BaseCompanyData data);

    Response findAll(BaseCompanyQueryParameter params);

    int updateStatusById(BaseCompanyData data);

    int deleteById(Long id);

    Response findBaseCompanyByArea(BaseCompanyNameQueryParameter parameter);

    String saveBaseCompanyGeoHash(BaseCompanyGeoHashSaveParameter parameter);

    int deleteBaseCompanyGeoHashByCompanyId(Long id);

    List<BaseCompanyData> findCompaniesByMap(List<String> mapGeoHash);

    int countByCompanyName(BaseCompanyNameParameter parameter);

}
