package com.hema.newretail.backstage.entry.grid;

import java.math.BigDecimal;
import java.util.Date;

public class GridKpiModeEntry {

    /***/
    private Long id;

    /**密度最小值*/
    private Integer densityRangeMin;

    /**密度最大值*/
    private Integer densityRangeMax;

    /**任务良好奖励值*/
    private Integer taskGoodReward;

    /**补货任务分值*/
    private Integer replenishmentReward;

    /**保洁任务分值*/
    private Integer cleanupReward;

    /**换件任务分值*/
    private Integer replaceReward;

    /**维修任务分值*/
    private Integer maintenanceReward;

    /**巡检任务分值*/
    private Integer inspectionReward;

    /**分值金额*/
    private BigDecimal rewardAmount;

    /**修改时间*/
    private Date gmtModified;

    /**创建时间*/
    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDensityRangeMin() {
        return densityRangeMin;
    }

    public void setDensityRangeMin(Integer densityRangeMin) {
        this.densityRangeMin = densityRangeMin;
    }

    public Integer getDensityRangeMax() {
        return densityRangeMax;
    }

    public void setDensityRangeMax(Integer densityRangeMax) {
        this.densityRangeMax = densityRangeMax;
    }

    public Integer getTaskGoodReward() {
        return taskGoodReward;
    }

    public void setTaskGoodReward(Integer taskGoodReward) {
        this.taskGoodReward = taskGoodReward;
    }

    public Integer getReplenishmentReward() {
        return replenishmentReward;
    }

    public void setReplenishmentReward(Integer replenishmentReward) {
        this.replenishmentReward = replenishmentReward;
    }

    public Integer getCleanupReward() {
        return cleanupReward;
    }

    public void setCleanupReward(Integer cleanupReward) {
        this.cleanupReward = cleanupReward;
    }

    public Integer getReplaceReward() {
        return replaceReward;
    }

    public void setReplaceReward(Integer replaceReward) {
        this.replaceReward = replaceReward;
    }

    public Integer getMaintenanceReward() {
        return maintenanceReward;
    }

    public void setMaintenanceReward(Integer maintenanceReward) {
        this.maintenanceReward = maintenanceReward;
    }

    public Integer getInspectionReward() {
        return inspectionReward;
    }

    public void setInspectionReward(Integer inspectionReward) {
        this.inspectionReward = inspectionReward;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}