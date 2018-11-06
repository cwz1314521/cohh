package com.hema.newretail.backstage.model.menu;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.model.menu
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-29 13:57
 */
public class RefMenuIngredientBo {

    private Long menuId;
    private Long ingredientId;
    private String ingredientName;
    private Long num;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
