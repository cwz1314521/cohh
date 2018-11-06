package com.hema.newretail.backstage.entry.grid;

import java.math.BigDecimal;
import java.util.Date;

public class GridIntegralRuleEntry {
    private Long id;

    private Long gridCompanyId;

    /**每分对应金额*/
    private BigDecimal rewardAmount;
    /**补货任务时间*/
    private Integer replenishmentTime;
    /**保洁任务时间*/
    private Integer cleanupReward;
    /**换件任务时间*/
    private Integer replaceReward;
    /**维修任务时间*/
    private Integer maintenanceReward;
    /**巡检任务时间*/
    private Integer inspectionReward;

    private Date gmtCreate;
    /**生效时间*/
    private Date effectiveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGridCompanyId() {
        return gridCompanyId;
    }

    public void setGridCompanyId(Long gridCompanyId) {
        this.gridCompanyId = gridCompanyId;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Integer getReplenishmentTime() {
        return replenishmentTime;
    }

    public void setReplenishmentTime(Integer replenishmentTime) {
        this.replenishmentTime = replenishmentTime;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}