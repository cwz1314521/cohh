package com.hema.newretail.backstage.dao;

import com.hema.newretail.backstage.entry.RefMenuIngredient;
import com.hema.newretail.backstage.model.menu.RefMenuIngredientBo;

import java.util.List;

public interface RefMenuIngredientMapper {
    int insert(RefMenuIngredient record);

    int insertSelective(RefMenuIngredient record);

    /**
     *
     * @param menuId
     * @return
     */
    List<RefMenuIngredientBo> selectIngredientByMenuId(Long menuId);
}