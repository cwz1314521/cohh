package com.hema.newretail.backstage.entry.orderentry;

/**
 * @Auther: 程文政
 * @Date: 2018/8/23 13:17
 * @Description:
 * @Version: 1.0
 */
public class Ingredients {

    private String id;
    private String price;
    private Integer num;
    private String picture;
    private String ingredientsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }
}
