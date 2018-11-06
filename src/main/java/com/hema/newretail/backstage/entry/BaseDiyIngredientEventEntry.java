package com.hema.newretail.backstage.entry;

public class BaseDiyIngredientEventEntry {
    private Long id;

    private Long diySettingId;

    private Long ingredientId;

    private String markedWords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiySettingId() {
        return diySettingId;
    }

    public void setDiySettingId(Long diySettingId) {
        this.diySettingId = diySettingId;
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