package com.hema.newretail.backstage.service.impl;

import com.hema.newretail.backstage.common.queryparam.BaseCompanyDeleteParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashInitMapParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashQueryParameter;
import com.hema.newretail.backstage.dao.BaseCompanyGeoHashMapper;
import com.hema.newretail.backstage.entry.BaseCompanyGeoHashData;
import com.hema.newretail.backstage.service.IBaseCompanyGeoHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 分公司服务区域接口实现类
 * @Author: Mr.Yang
 * @Date: 2018/09/26
 **/
@Service("baseCompanyGeoHashService")
public class BaseCompanyGeoHashServiceImpl implements IBaseCompanyGeoHashService {

    @Autowired
    private BaseCompanyGeoHashMapper baseCompanyGeoHashMapper;

    @Override
    public int countByBaseCompanyId(Long id) {
        return baseCompanyGeoHashMapper.countByBaseCompanyId(id);
    }

    @Override
    public List<BaseCompanyGeoHashData> findServiceAreaByBaseCompanyId(BaseCompanyDeleteParameter parameter) {
        return baseCompanyGeoHashMapper.findServiceAreaByBaseCompanyId(parameter.getId());
    }

    @Override
    public List<String> initMapGeoHash(BaseCompanyGeoHashInitMapParameter parameter) {
        List<String> usedGeoHash = baseCompanyGeoHashMapper.freeGeoHash(parameter.getMapGeoHash());

        return usedGeoHash;
    }

    @Override
    public Map<String, List<String>> queryBaseCompanyGeoHash(BaseCompanyGeoHashQueryParameter parameter) {
        Map<String,List<String>> result = new HashMap<String,List<String>>();
        List<String> usedGeoHash = baseCompanyGeoHashMapper.freeGeoHash(parameter.getMapGeoHash());

        List<String> baseCompanyGeoHash = baseCompanyGeoHashMapper.findBaseCompanyGeoHashByCompanyId(parameter.getBaseCompanyId());

        List<String> otherCompanyGeoHash = new ArrayList<String>();

        if(baseCompanyGeoHash.size()>0){
            if (usedGeoHash.removeAll(baseCompanyGeoHash)){
                otherCompanyGeoHash = usedGeoHash;
            }
        }else {
            otherCompanyGeoHash = usedGeoHash;
        }

        result.put("otherCompanyGeoHash",otherCompanyGeoHash);
        result.put("baseCompanyGeoHash",baseCompanyGeoHash);

        return result;
    }
}
