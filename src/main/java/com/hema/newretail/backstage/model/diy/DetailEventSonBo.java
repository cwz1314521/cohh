package com.hema.newretail.backstage.model.diy;

/**
 * @Department 新零售
 * @ClassName DetailEventSonBo
 * @Description detail
 * @Author ---CWZ
 * @Date 2018/10/18 12:53
 * @Version 1.0
 **/
public class DetailEventSonBo {


    private String markedWords;

    private String ingredientName;

    private Long ingredientId;

    public Long getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getMarkedWords() {
        return markedWords;
    }

    public void setMarkedWords(String markedWords) {
        this.markedWords = markedWords;
    }
}
