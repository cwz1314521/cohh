package com.hema.newretail.backstage.model.erp;



/**
 * @Department 新零售
 * @ClassName OrderListIngredientBo
 * @Description 订单列表----原料
 * @Author ---CWZ
 * @Date 2018/11/1 15:29
 * @Version 1.0
 **/
public class OrderListIngredientBo {


    /**原料ID*/
    private Long ingredientId;

    /**原料名称*/
    private String ingredientName;

    /**原料符号*/
    private String ingredientCode;

    private  Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getIngredientCode() {
        return ingredientCode;
    }

    public void setIngredientCode(String ingredientCode) {
        this.ingredientCode = ingredientCode;
    }
}
