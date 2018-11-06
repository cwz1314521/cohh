package com.hema.newretail.backstage.model.tag;

public class BaseIngredientBoxInfoBo {

    private String boxCodes;

    public String getBoxCodes() {
        return boxCodes;
    }

    public void setBoxCodes(String boxCodes) {
        this.boxCodes = boxCodes;
    }

    //料盒
    private Long id;

    //料盒码
    private Integer boxCode;

    //料种id
    private Long ingredientId;

    //料种id
    private String ingredientName;

    //每份时间（ms）
    private Integer duration;

    //每份体积（ml）
    private Integer capacity;

    //每瓶最多可释放份数
    private Integer maxCopies;

    //预警份数（%）
    private Float warnPercent;

    //料盒组
    private Long boxGroupId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(Integer boxCode) {
        this.boxCode = boxCode;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getMaxCopies() {
        return maxCopies;
    }

    public void setMaxCopies(Integer maxCopies) {
        this.maxCopies = maxCopies;
    }

    public Float getWarnPercent() {
        return warnPercent;
    }

    public void setWarnPercent(Float warnPercent) {
        this.warnPercent = warnPercent;
    }

    public Long getBoxGroupId() {
        return boxGroupId;
    }

    public void setBoxGroupId(Long boxGroupId) {
        this.boxGroupId = boxGroupId;
    }
}