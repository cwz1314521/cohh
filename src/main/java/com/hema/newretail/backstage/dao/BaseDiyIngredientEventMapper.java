package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseDiyIngredientEventEntry;

public interface BaseDiyIngredientEventMapper {

    int deleteBySettingId(Long id);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDiyIngredientEventEntry record);

    int insertSelective(BaseDiyIngredientEventEntry record);

    BaseDiyIngredientEventEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseDiyIngredientEventEntry record);

    int updateByPrimaryKey(BaseDiyIngredientEventEntry record);
}