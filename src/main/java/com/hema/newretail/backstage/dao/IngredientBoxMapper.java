package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.IngredientBox;

public interface IngredientBoxMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IngredientBox record);

    int insertSelective(IngredientBox record);

    IngredientBox selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IngredientBox record);

    int updateByPrimaryKey(IngredientBox record);
}