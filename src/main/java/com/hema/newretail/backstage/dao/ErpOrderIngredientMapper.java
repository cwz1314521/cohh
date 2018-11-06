package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.erp.ErpOrderIngredientEntry;

public interface ErpOrderIngredientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ErpOrderIngredientEntry record);

    int insertSelective(ErpOrderIngredientEntry record);

    ErpOrderIngredientEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ErpOrderIngredientEntry record);

    int updateByPrimaryKey(ErpOrderIngredientEntry record);
}