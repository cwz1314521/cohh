package com.hema.newretail.backstage.model.erp;

/**
 * @Department 新零售
 * @ClassName AddressIngredientBo
 * @Description 地址-原料-列表
 * @Author ---CWZ
 * @Date 2018/11/1 15:47
 * @Version 1.0
 **/
public class AddressIngredientBo {

    /**id*/
    private Long orderIngredientId;

    /**原料id*/
    private Long ingredientId;

    /**数量*/
    private Integer num;

    /**原料名称*/
    private String ingredientName;

    public Long getOrderIngredientId() {
        return orderIngredientId;
    }

    public void setOrderIngredientId(Long orderIngredientId) {
        this.orderIngredientId = orderIngredientId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
