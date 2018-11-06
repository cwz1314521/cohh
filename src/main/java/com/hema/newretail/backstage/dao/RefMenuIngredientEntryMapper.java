package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.RefMenuIngredientEntry;
import org.springframework.stereotype.Component;

@Component
public interface RefMenuIngredientEntryMapper {
    int insert(RefMenuIngredientEntry record);

    int insertSelective(RefMenuIngredientEntry record);

    void saveMaterialList(RefMenuIngredientEntry refMenuIngredientEntry);

    void updateMaterialList(RefMenuIngredientEntry refMenuIngredientEntry);

    int deleteByIngredientMenuId(Long id);
}