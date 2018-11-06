package com.hema.newretail.backstage.model.diy;

/**
 * @Department 新零售
 * @ClassName IngredientBo
 * @Description 返回值类---所有配料
 * @Author ---CWZ
 * @Date 2018/10/18 10:42
 * @Version 1.0
 **/
public class IngredientBo {

    private Long id;

    private String ingredientName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
