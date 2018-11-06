package com.hema.newretail.backstage.model.diy;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName DetailEventBo
 * @Description detail
 * @Author ---CWZ
 * @Date 2018/10/18 12:52
 * @Version 1.0
 **/
public class DetailEventBo {

    private Long id ;

    private String ingredientName;

    private String ingredientId;

    private BigDecimal maxIngredient;

    private Integer maxTime;

    private List<DetailEventSonBo> list;


    private String markedWords;

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getMarkedWords() {
        return markedWords;
    }

    public void setMarkedWords(String markedWords) {
        this.markedWords = markedWords;
    }

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

    public BigDecimal getMaxIngredient() {
        return maxIngredient;
    }

    public void setMaxIngredient(BigDecimal maxIngredient) {
        this.maxIngredient = maxIngredient;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public List<DetailEventSonBo> getList() {
        return list;
    }

    public void setList(List<DetailEventSonBo> list) {
        this.list = list;
    }
}
