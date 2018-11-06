package com.hema.newretail.backstage.entry;

public class BaseMachineBoxLogEntry {
    private Long id;

    private Integer boxCode;

    private Long ingredientId;

    private Integer duration;

    private Integer capacity;

    private Integer maxCopies;

    private Float warnPercent;

    private String geoHash;

    private Integer status;

    private Long gmtCreate;

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

    public String getGeoHash() {
        return geoHash;
    }

    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash == null ? null : geoHash.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}