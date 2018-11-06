package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BusiIngredientMenuEntry;

import java.util.List;

public interface BusiIngredientMenuMapper {
    List<BusiIngredientMenuEntry> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(BusiIngredientMenuEntry record);

    int insertSelective(BusiIngredientMenuEntry record);

    BusiIngredientMenuEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusiIngredientMenuEntry record);

    int updateByPrimaryKey(BusiIngredientMenuEntry record);

    void saveStandardDrink(BusiIngredientMenuEntry busiIngredientMenuEntry);

    BusiIngredientMenuEntry selectStandardDrink(String menuName);
}