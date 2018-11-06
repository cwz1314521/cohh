package com.hema.newretail.backstage.service;

import com.hema.newretail.backstage.entry.BaseIngredientInfoEntry;
import com.hema.newretail.backstage.model.menu.IngredientMenuBo;
import com.hema.newretail.backstage.model.menuproperties.PropertyTypeBo;

import java.util.List;
import java.util.Map;

/**
 * hema-newetaril-com.hema.newretail.backstage.service
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-23 11:22
 */
public interface IIngredientMenuService {
    /**
     * 根据条件查询饮品数据
     *
     * @param params
     * @return
     */
    List<IngredientMenuBo> queryDataByConditions(Map<String, Object> params);

    /**
     * 批量删除商品
     *
     * @param ids
     * @return
     */
    int deleteBatch(Long[] ids);

    /**
     * 查询所有配料
     *
     * @return
     */
    List<BaseIngredientInfoEntry> queryAllIngredient();

    /**
     * 查询所有属性分类
     *
     * @return
     */
    List<PropertyTypeBo> queryPropertyList();

    /**
     * 根据menuId查询饮品详细信息
     *
     * @param menuId
     * @return
     */
    Map<String, Object> queryMenuDetailByMenuId(Long menuId);

    /**
     * 初始化添加饮品页面的初始数据
     *
     * @return
     */
    Map<String, Object> queryInitDataForInsertMenu();

    /**
     * 根据标签和饮品更新标签的量级
     *
     * @param tagId
     * @param menuId
     * @param num
     */
    void updateNumByTagidAndMenuid(Long tagId, Long menuId, int num);
}
