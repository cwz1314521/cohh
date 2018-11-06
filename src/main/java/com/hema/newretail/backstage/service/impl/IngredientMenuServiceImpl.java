package com.hema.newretail.backstage.service.impl;

import com.hema.newretail.backstage.dao.*;
import com.hema.newretail.backstage.entry.*;
import com.hema.newretail.backstage.model.menu.IngredientMenuBo;
import com.hema.newretail.backstage.model.menu.MenuPropertiesBo;
import com.hema.newretail.backstage.model.menu.RefMenuIngredientBo;
import com.hema.newretail.backstage.model.menu.TagMenuBo;
import com.hema.newretail.backstage.model.menuproperties.PropertyTypeBo;
import com.hema.newretail.backstage.service.IIngredientMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hema-newetaril-com.hema.newretail.backstage.service.impl
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-23 11:23
 */
@Service("ingredientMenuService")
public class IngredientMenuServiceImpl implements IIngredientMenuService {
    @Autowired
    private IngredientMenuEntryMapper ingredientMenuEntryMapper;
    @Autowired
    private BaseIngredientInfoEntryMapper baseIngredientInfoEntryMapper;
    @Autowired
    private BasePropertiesTypeEntryMapper basePropertiesTypeEntryMapper;
    @Autowired
    private BaseTagRuleEntryMapper baseTagRuleEntryMapper;
    @Autowired
    private RefMenuIngredientMapper refMenuIngredientMapper;
    @Autowired
    private BaseMenuPropertiesEntryMapper baseMenuPropertiesEntryMapper;
    @Autowired
    private BaseTagEntryMapper baseTagEntryMapper;

    /**
     * @param params
     * @return
     */
    @Override
    public List<IngredientMenuBo> queryDataByConditions(Map<String, Object> params) {
        return ingredientMenuEntryMapper.selectDataByCondition(params, (Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public int deleteBatch(Long[] ids) {
        return ingredientMenuEntryMapper.deleteBatch(ids);
    }

    /**
     * @return
     */
    @Override
    public List<BaseIngredientInfoEntry> queryAllIngredient() {
        return baseIngredientInfoEntryMapper.selectAll();
    }

    /**
     * @return
     */
    @Override
    public List<PropertyTypeBo> queryPropertyList() {
        return basePropertiesTypeEntryMapper.selectAllType();
    }

    @Override
    public Map<String, Object> queryMenuDetailByMenuId(Long menuId) {
        //饮品标签列表
        List<TagMenuBo> tagMenuBoList = baseTagRuleEntryMapper.selectDataByMenuid(menuId);
        // 饮品信息
        IngredientMenuEntry ingredientMenuEntry = ingredientMenuEntryMapper.selectByPrimaryKey(menuId);
        // 饮品配料列表
        List<RefMenuIngredientBo> refMenuIngredientList = refMenuIngredientMapper.selectIngredientByMenuId(menuId);
        // 饮品属性列表
        List<MenuPropertiesBo> menuPropertiesBoList = baseMenuPropertiesEntryMapper.selectMenuProByMenuId(menuId);
        // 查询所有标签
        List<BaseTagEntry> tagEntryList = baseTagEntryMapper.selectNotDelete();
        // 查询所有饮品
        List<BaseIngredientInfoEntry> ingredientInfoEntryList = baseIngredientInfoEntryMapper.selectAll();

        Map<String, Object> map = new HashMap<>(6);
        map.put("menuTagList", tagMenuBoList);
        map.put("menu", ingredientMenuEntry);
        map.put("MenuIngredientList", refMenuIngredientList);
        map.put("menuProList", menuPropertiesBoList);
        map.put("tagList", tagEntryList);
        map.put("ingredientList", ingredientInfoEntryList);
        return map;
    }

    @Override
    public Map<String, Object> queryInitDataForInsertMenu() {
        // 查询所有配料
        List<BaseIngredientInfoEntry> ingredientInfoEntryList = baseIngredientInfoEntryMapper.selectAll();
        // 初始化属性
        List<PropertyTypeBo> propertyTypeBoList = basePropertiesTypeEntryMapper.selectAllType();

        Map<String, Object> map = new HashMap<>(2);
        map.put("proTypeList", propertyTypeBoList);
        map.put("ingredientList", ingredientInfoEntryList);
        return map;
    }

    @Override
    public void updateNumByTagidAndMenuid(Long tagId, Long menuId, int num) {
        BaseTagRuleEntry tagRule = new BaseTagRuleEntry();
        tagRule.setNum(num);
        tagRule.setTagId(tagId);
        tagRule.setMenuId(menuId);
        baseTagRuleEntryMapper.updateByTagidAndMenuid(tagRule);
    }

}
