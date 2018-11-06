package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.common.queryparam.diy.NameCondition;
import com.hema.newretail.backstage.entry.BaseDiyIngredientSettingEntry;
import com.hema.newretail.backstage.model.diy.DetailEventBo;
import com.hema.newretail.backstage.model.diy.IngredientEventBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDiyIngredientSettingMapper {



    DetailEventBo selectDetail(@Param("id") Long id);

    List<IngredientEventBo> selectAllEvent(NameCondition nameCondition);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDiyIngredientSettingEntry record);

    int insertSelective(BaseDiyIngredientSettingEntry record);

    BaseDiyIngredientSettingEntry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseDiyIngredientSettingEntry record);

    int updateByPrimaryKey(BaseDiyIngredientSettingEntry record);
}