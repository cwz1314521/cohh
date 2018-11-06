package com.hema.newretail.backstage.entry;

import java.math.BigDecimal;
import java.util.Date;

public class BaseDiyIngredientSettingEntry {
    private Long id;

    private BigDecimal maxIngredient;

    private Integer maxTime;

    private Date gmtCreate;

    private Date gmtModified;

    private Long ingredientId;

    private String markedWords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getMarkedWords() {
        return markedWords;
    }

    public void setMarkedWords(String markedWords) {
        this.markedWords = markedWords == null ? null : markedWords.trim();
    }
}