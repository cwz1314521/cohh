package com.hema.newretail.backstage.entry;

public class IngredientBox {
    private Long id;

    private Integer boxCode;

    private String machineCode;

    private String geoHashcode;

    private Long ingredientId;

    private Integer duration;

    private Integer capacity;

    private Integer maxCopies;

    private Float warnPercent;

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

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

    public String getGeoHashcode() {
        return geoHashcode;
    }

    public void setGeoHashcode(String geoHashcode) {
        this.geoHashcode = geoHashcode == null ? null : geoHashcode.trim();
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