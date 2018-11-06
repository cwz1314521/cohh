package com.hema.newretail.backstage.entry.erp;

public class ErpOrderIngredientEntry {
    private Long id;

    private Long ingredientOrderAddressId;

    private Long ingredientId;

    private Integer num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIngredientOrderAddressId() {
        return ingredientOrderAddressId;
    }

    public void setIngredientOrderAddressId(Long ingredientOrderAddressId) {
        this.ingredientOrderAddressId = ingredientOrderAddressId;
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

    @Override
    public String toString() {
        return "ErpOrderIngredientEntry{" +
                "id=" + id +
                ", ingredientOrderAddressId=" + ingredientOrderAddressId +
                ", ingredientId=" + ingredientId +
                ", num=" + num +
                '}';
    }
}