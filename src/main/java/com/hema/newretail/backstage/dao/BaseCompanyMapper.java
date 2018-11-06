package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.BaseCompanyNameParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyNameQueryParameter;
import com.hema.newretail.backstage.common.queryparam.BaseCompanyQueryParameter;
import com.hema.newretail.backstage.common.queryparam.erp.ListManufacturerCondition;
import com.hema.newretail.backstage.entry.BaseCompanyData;
import com.hema.newretail.backstage.model.erp.ListManufacturerBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseCompanyMapper {


    List<ListManufacturerBo> selectBySelect(ListManufacturerCondition listManufacturerCondition);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCompanyData record);

    int insertSelective(BaseCompanyData record);

    BaseCompanyData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseCompanyData record);

    int updateByPrimaryKey(BaseCompanyData record);

    List<BaseCompanyData> selectAll();

    int updateStatusById(BaseCompanyData data);

    List<BaseCompanyData> findAll(BaseCompanyQueryParameter parameter);

    List<BaseCompanyData> findBaseCompanyByArea(BaseCompanyNameQueryParameter parameter);

    List<BaseCompanyData> findCompanysByIds(@Param("ids") List<Long> ids);

    int countByCompanyName(BaseCompanyNameParameter parameter);
}