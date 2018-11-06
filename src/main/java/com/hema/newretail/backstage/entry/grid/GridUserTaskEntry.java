package com.hema.newretail.backstage.entry.grid;

import java.util.Date;

public class GridUserTaskEntry {
    private Long taskId;

    private Long userId;

    private Integer taskStatus;

    private Date taskStartTime;

    private Date taskEndTime;

    private Long kpi;

    private Date assessmentTaskEndTime;

    private String taskStartPic;

    private String taskEndPic;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public Long getKpi() {
        return kpi;
    }

    public void setKpi(Long kpi) {
        this.kpi = kpi;
    }

    public Date getAssessmentTaskEndTime() {
        return assessmentTaskEndTime;
    }

    public void setAssessmentTaskEndTime(Date assessmentTaskEndTime) {
        this.assessmentTaskEndTime = assessmentTaskEndTime;
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
}