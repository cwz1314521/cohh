package com.hema.newretail.backstage.entry.grid;

import java.util.Date;

public class GridTasksEntry {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer taskType;

    private Date startTime;

    private Date endTime;

    private Long gridUserId;

    private String preDuration;

    private String taskCode;

    private Integer taskStatus;

    private String machineUuid;

    private Long assigner;

    private Date assignTime;

    private Double machineLat;

    private Double machineLon;

    private String machineDesc;

    private String geoHash;

    private String taskStartPic;

    private String taskEndPic;

    private String taskDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getGridUserId() {
        return gridUserId;
    }

    public void setGridUserId(Long gridUserId) {
        this.gridUserId = gridUserId;
    }

    public String getPreDuration() {
        return preDuration;
    }

    public void setPreDuration(String preDuration) {
        this.preDuration = preDuration == null ? null : preDuration.trim();
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getMachineUuid() {
        return machineUuid;
    }

    public void setMachineUuid(String machineUuid) {
        this.machineUuid = machineUuid == null ? null : machineUuid.trim();
    }

    public Long getAssigner() {
        return assigner;
    }

    public void setAssigner(Long assigner) {
        this.assigner = assigner;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Double getMachineLat() {
        return machineLat;
    }

    public void setMachineLat(Double machineLat) {
        this.machineLat = machineLat;
    }

    public Double getMachineLon() {
        return machineLon;
    }

    public void setMachineLon(Double machineLon) {
        this.machineLon = machineLon;
    }

    public String getMachineDesc() {
        return machineDesc;
    }

    public void setMachineDesc(String machineDesc) {
        this.machineDesc = machineDesc == null ? null : machineDesc.trim();
    }

    public String getGeoHash() {
        return geoHash;
    }

    public void setGeoHash(String geoHash) {
        this.geoHash = geoHash == null ? null : geoHash.trim();
    }

    public String getTaskStartPic() {
        return taskStartPic;
    }

    public void setTaskStartPic(String taskStartPic) {
        this.taskStartPic = taskStartPic == null ? null : taskStartPic.trim();
    }

    public String getTaskEndPic() {
        return taskEndPic;
    }

    public void setTaskEndPic(String taskEndPic) {
        this.taskEndPic = taskEndPic == null ? null : taskEndPic.trim();
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails == null ? null : taskDetails.trim();
    }
}