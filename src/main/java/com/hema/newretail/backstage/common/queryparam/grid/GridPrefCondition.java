package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Department 新零售
 * @ClassName GridPrefCondition
 * @Description 绩效考核添加参数类
 * @Author ---CWZ
 * @Date 2018/9/30 13:38
 * @Version 1.0
 **/
@ApiModel(value = "GridPrefCondition",description = "绩效考核添加参数类")
public class GridPrefCondition {

    @NotNull(message = "密度范围最小值不可以为空")
    @ApiModelProperty(value = "密度范围最小值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer densityRangeMin;

    @NotNull(message = "密度范围最大值不可以为空")
    @ApiModelProperty(value = "密度范围最大值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer densityRangeMax;

    @NotNull(message = "任务良好奖励值不可以为空")
    @ApiModelProperty(value = "任务良好奖励值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer taskGoodReward;

    @NotNull(message = "补货任务分值不可以为空")
    @ApiModelProperty(value = "补货任务分值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer replenishmentReward;

    @NotNull(message = "保洁任务分值不可以为空")
    @ApiModelProperty(value = "保洁任务分值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer cleanupReward;

    @NotNull(message = "换件任务分值不可以为空")
    @ApiModelProperty(value = "换件任务分值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer replaceReward;

    @NotNull(message = "维修任务分值不可以为空")
    @ApiModelProperty(value = "维修任务分值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer maintenanceReward;

    @NotNull(message = "巡检任务分值不可以为空")
    @ApiModelProperty(value = "巡检任务分值")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    private Integer inspectionReward;

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
}
