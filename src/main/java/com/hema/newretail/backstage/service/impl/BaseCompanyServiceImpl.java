package com.hema.newretail.backstage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyGeoHashSaveParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyNameParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyNameQueryParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyQueryParameter;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.dao.BaseCompanyGeoHashMapper;
import com.hema.newretail.backstage.dao.BaseCompanyMapper;
import com.hema.newretail.backstage.entry.BaseCompanyData;
import com.hema.newretail.backstage.entry.BaseCompanyGeoHashData;
import com.hema.newretail.backstage.service.IBaseCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 分公司管理服务接口实现类
 * @Author: Mr.Yang
 * @Date: 2018/09/25
 **/
@Service("baseCompanyService")
public class BaseCompanyServiceImpl implements IBaseCompanyService {

    @Autowired
    private BaseCompanyMapper baseCompanyMapper;

    @Autowired
    private BaseCompanyGeoHashMapper baseCompanyGeoHashMapper;

    private Pattern pattern = Pattern.compile("[0-9]*");

    @Override
    public int saveBaseCompany(BaseCompanyData data) {
        int result = 0;
        if(data.getId()==null){
            data.setGmtCreate(new Date());
            result = baseCompanyMapper.insertSelective(data);
        }else{
            data.setGmtModified(new Date());
            result = baseCompanyMapper.updateByPrimaryKeySelective(data);
        }
        return result;
    }

    @Override
    public Response findAll(BaseCompanyQueryParameter params) {
        String companyNameOrId = params.getCompanyNameOrId();
        if(companyNameOrId != null && !"".equals(companyNameOrId)){
            /**
             * 利用正则表达式判断字符串是否是数字
             */
            Matcher isNum = pattern.matcher(companyNameOrId);
            if(!isNum.matches()){
                params.setCompanyName(companyNameOrId);
            }else{
                params.setCompanyName(companyNameOrId);
                params.setId(Long.valueOf(companyNameOrId));
            }
        }
        Page<BaseCompanyData> page = PageHelper.startPage(params.getPageNum(), params.getPageSize());
        baseCompanyMapper.findAll(params);
//        PageInfo<BaseCompanyData> pageInfo = new PageInfo<BaseCompanyData>(data);
        return Response.success(page.getResult(),page.getTotal(),params.getPageSize(),params.getPageNum());
    }

    @Override
    public int updateStatusById(BaseCompanyData data) {
        return baseCompanyMapper.updateByPrimaryKeySelective(data);
    }

    @Override
    public int deleteById(Long id) {
        return baseCompanyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Response findBaseCompanyByArea(BaseCompanyNameQueryParameter parameter) {
        Page<BaseCompanyData> page = PageHelper.startPage(parameter.getPageNum(), parameter.getPageSize());
        baseCompanyMapper.findBaseCompanyByArea(parameter);
        return Response.success(page.getResult(),page.getTotal(),parameter.getPageSize(),parameter.getPageNum());
    }

    @Override
    @Transactional
    public String saveBaseCompanyGeoHash(BaseCompanyGeoHashSaveParameter parameter) {
        String message = "";

        List<BaseCompanyGeoHashData> list = new ArrayList<BaseCompanyGeoHashData>();
        List<String> geoHash = parameter.getBaseCompanyGeoHash();
        for (String item:geoHash){
            BaseCompanyGeoHashData data = new BaseCompanyGeoHashData();
            data.setCompanyId(parameter.getBaseCompanyId());
            data.setGeoHashCode(item);
            list.add(data);
        }
        int count = baseCompanyGeoHashMapper.countByBaseCompanyId(parameter.getBaseCompanyId());
        if(count>0){
            int delCount = baseCompanyGeoHashMapper.deleteByCompanyId(parameter.getBaseCompanyId());
            if (delCount==count){
                if (list.size()>0){
                    int saveCount = baseCompanyGeoHashMapper.insertBatchBaseCompanyGeoHash(list);
                    if(saveCount != list.size()){
                        message = "没有保存所有的网格";
                    }
                }
            }else {
                message = "删除原有的区域没有彻底删除";
            }
        }else {
            if(list.size()>0){
                int saveCount = baseCompanyGeoHashMapper.insertBatchBaseCompanyGeoHash(list);
                if(saveCount != list.size()){
                    message = "没有保存所有的网格";
                }
            }
        }

        return message;
    }

    @Override
    public int deleteBaseCompanyGeoHashByCompanyId(Long id) {
        return baseCompanyGeoHashMapper.deleteByCompanyId(id);
    }

    @Override
    public List<BaseCompanyData> findCompaniesByMap(List<String> mapGeoHash) {
        List<BaseCompanyData> result = new ArrayList<BaseCompanyData>();
        List<BaseCompanyGeoHashData> data = baseCompanyGeoHashMapper.findGeoHashs(mapGeoHash);
        List<Long> companyIds = new ArrayList<Long>();

        for (BaseCompanyGeoHashData item:data){
            if(companyIds.size()>0){
                if (companyIds.contains(item.getCompanyId())){
                    continue;
                }else {
                    companyIds.add(item.getCompanyId());
                }
            }else {
                companyIds.add(item.getCompanyId());
            }
        }
        if (companyIds.size()>0){
            result = baseCompanyMapper.findCompanysByIds(companyIds);
            for (int i=0;i<result.size();i++){
                BaseCompanyData company = result.get(i);
                List<String> geoHashs = new ArrayList<String>();
                for (BaseCompanyGeoHashData item:data){
                    if (company.getId().equals(item.getCompanyId())){
                        geoHashs.add(item.getGeoHashCode());
                    }
                }
                company.setAddress(company.getProvince()+company.getCity()+company.getArea());
                company.setGeoHashCodes(geoHashs);
                result.add(i,company);
            }
        }

        return result;
    }

    @Override
    public int countByCompanyName(BaseCompanyNameParameter parameter) {
        return baseCompanyMapper.countByCompanyName(parameter);
    }
}
