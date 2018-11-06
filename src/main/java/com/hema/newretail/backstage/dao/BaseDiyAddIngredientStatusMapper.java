package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseDiyAddIngredientStatusEntry;

import java.util.List;

public interface BaseDiyAddIngredientStatusMapper {


    List<BaseDiyAddIngredientStatusEntry> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(BaseDiyAddIngredientStatusEntry record);

    int insertSelective(BaseDiyAddIngredientStatusEntry record);

    BaseDiyAddIngredientStatusEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseDiyAddIngredientStatusEntry record);

    int updateByPrimaryKey(BaseDiyAddIngredientStatusEntry record);
}