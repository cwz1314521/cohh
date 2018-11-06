package com.hema.newretail.backstage.entry.orderentry;

import java.math.BigDecimal;

/**
 * Created by jiahao on 2018-08-16
 */
public class OrderIngredients {

    private String id;

    private String picture;//配料图

    private Integer num;

    private BigDecimal price;

    private String ingredientsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }
}
