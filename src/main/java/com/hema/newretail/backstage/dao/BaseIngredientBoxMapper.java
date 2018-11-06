package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.BaseIngredientBoxEntry;
import com.hema.newretail.backstage.model.tag.BaseIngredientBoxInfoBo;

import java.util.List;

public interface BaseIngredientBoxMapper {

    List<BaseIngredientBoxInfoBo> selectBoxOrInfoByBoxGroupId(Long boxGroupId);

    int deleteByPrimaryKey(Long id);

    int deleteByGroupId(Long id);

    int insert(BaseIngredientBoxEntry record);

    int insertSelective(BaseIngredientBoxEntry record);

    BaseIngredientBoxEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseIngredientBoxEntry record);

    int updateByPrimaryKey(BaseIngredientBoxEntry record);
}