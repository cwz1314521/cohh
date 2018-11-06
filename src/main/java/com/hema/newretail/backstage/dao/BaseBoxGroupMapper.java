package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.agent.CountNameCondition;
import com.hema.newretail.backstage.entry.BaseBoxGroupEntry;
import com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition.IngredientCondition;

import java.util.List;

public interface BaseBoxGroupMapper {


    int selectCountByNameThisId(CountNameCondition countNameCondition);

    //根据机器类型分类查询
    List<BaseBoxGroupEntry> selectByMachineTypeId(IngredientCondition ingredientCondition);

    List<BaseBoxGroupEntry> selectByName(String name);

    int deleteByPrimaryKey(Long id);

    int insert(BaseBoxGroupEntry record);

    int insertSelective(BaseBoxGroupEntry record);

    BaseBoxGroupEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseBoxGroupEntry record);

    int updateByPrimaryKey(BaseBoxGroupEntry record);
}