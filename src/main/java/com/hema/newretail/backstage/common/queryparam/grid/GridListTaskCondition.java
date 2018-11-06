package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Department 新零售
 * @ClassName GridListTaskCondition
 * @Description 网格任务列表  ---  参数类
 * @Author ---CWZ
 * @Date 2018/9/28 11:11
 * @Version 1.0
 **/
@ApiModel(value = "GridListTaskCondition",description = "网格任务列表  ---  参数类")
public class GridListTaskCondition {

    /**页码  默认为1*/
    @NotNull(message = "页码不可以为空")
    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    /**每页最大数  默认为10*/
    @ApiModelProperty(value = "每页最大数")
    @NotNull(message = "每页最大数不可以为空")

    private Integer pageSize;
    /**省*/
    @ApiModelProperty(value = "省")
    private String province;

    /**市*/
    @ApiModelProperty(value = "市")
    private String city;

    /**多选区数组*/
    @ApiModelProperty(value = "多选区数组")
    private String [] area;

    /**任务编号*/
    @ApiModelProperty(value = "任务编号")
    private String taskCode;

    /**任务编号*/
    @ApiModelProperty(value = "任务进度")
    private String [] taskStatus;

    /**任务类型*/
    @ApiModelProperty(value = "任务类型")
    private Integer [] taskType;

    /**派发时间*/
    private Date preAssignTime;
    private Date assignTime;

    /**完成时间*/
    private Date preEndTime;
    private Date endTime;

    /**设备编号*/
    @ApiModelProperty(value = "设备编号")
    private Long machineUuid;

    /**网格公司*/
    @ApiModelProperty(value = "网格公司")
    private Long wId;

    /**派发时间-接收*/
    @ApiModelProperty(value = "派发时间-接收1")
    private String preAssignTimes;
    @ApiModelProperty(value = "派发时间-接收2")
    private String assignTimes;

    /**完成时间*/
    @ApiModelProperty(value = "完成时间1")
    private String preEndTimes;
    @ApiModelProperty(value = "完成时间2")
    private String endTimes;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getArea() {
        return area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String[] getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String[] taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer[] getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer[] taskType) {
        this.taskType = taskType;
    }

    public Date getPreAssignTime() {
        return preAssignTime;
    }

    public void setPreAssignTime(Date preAssignTime) {
        this.preAssignTime = preAssignTime;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Date getPreEndTime() {
        return preEndTime;
    }

    public void setPreEndTime(Date preEndTime) {
        this.preEndTime = preEndTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getMachineUuid() {
        return machineUuid;
    }

    public void setMachineUuid(Long machineUuid) {
        this.machineUuid = machineUuid;
    }

    public Long getwId() {
        return wId;
    }

    public void setwId(Long wId) {
        this.wId = wId;
    }

    public String getPreAssignTimes() {
        return preAssignTimes;
    }

    public void setPreAssignTimes(String preAssignTimes) {
        this.preAssignTimes = preAssignTimes;
    }

    public String getAssignTimes() {
        return assignTimes;
    }

    public void setAssignTimes(String assignTimes) {
        this.assignTimes = assignTimes;
    }

    public String getPreEndTimes() {
        return preEndTimes;
    }

    public void setPreEndTimes(String preEndTimes) {
        this.preEndTimes = preEndTimes;
    }

    public String getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(String endTimes) {
        this.endTimes = endTimes;
    }
}
