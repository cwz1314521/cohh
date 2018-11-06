package com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition;

public class BaseIngredientBoxCondition {

    //料盒
    private Long id;

    //料盒码
    private String boxCode;

    //料盒码
    private String boxCodes;

    //料种id
    private Long ingredientId;

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

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getBoxCodes() {
        return boxCodes;
    }

    public void setBoxCodes(String boxCodes) {
        this.boxCodes = boxCodes;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
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