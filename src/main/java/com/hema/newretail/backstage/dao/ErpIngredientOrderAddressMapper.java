package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.erp.ErpIngredientOrderAddressEntry;

public interface ErpIngredientOrderAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ErpIngredientOrderAddressEntry record);

    int insertSelective(ErpIngredientOrderAddressEntry record);

    ErpIngredientOrderAddressEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ErpIngredientOrderAddressEntry record);

    int updateByPrimaryKey(ErpIngredientOrderAddressEntry record);
}