package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.erp.ListManufacturerCondition;
import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.model.erp.ListManufacturerBo;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
public interface BaseIngredientInfoEntryMapper {


    List<ListManufacturerBo> selectBySelect(ListManufacturerCondition listManufacturerCondition);

    List<BaseIngredientInfoEntry> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(BaseIngredientInfoEntry record);

    int insertSelective(BaseIngredientInfoEntry record);

    BaseIngredientInfoEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseIngredientInfoEntry record);

    int updateByPrimaryKey(BaseIngredientInfoEntry record);

    List<BaseIngredientInfoEntry> findAll(Map<String,Object> params);

    int countByRefMenuIngredient(long id);

    int countByBasePropertiesType(long id);
}