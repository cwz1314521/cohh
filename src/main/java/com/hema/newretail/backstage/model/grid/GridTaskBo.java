package com.hema.newretail.backstage.model.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Department 新零售
 * @ClassName GridTaskBo
 * @Description 网格任务列表------model类----直接从数据库接收数据
 * @Author ---CWZ
 * @Date 2018/9/29 13:13
 * @Version 1.0
 **/
@ApiModel(value = "GridTaskBo",description = "网格任务列表------model类----直接从数据库接收数据")
public class GridTaskBo {

    /**主键*/
    @ApiModelProperty(value = "主键")
    private Long id;

    /**发布时间*/
    @ApiModelProperty(value = "发布时间")
    private Date gmtCreate;

    /**指派时间*/
    @ApiModelProperty(value = "指派时间")
    private Date assignTime;

    /**完成时间*/
    @ApiModelProperty(value = "完成时间")
    private Date endTime;

    /**任务状态*/
    @ApiModelProperty(value = "任务状态")
    private Integer taskStatus;

    /**任务类型*/
    @ApiModelProperty(value = "任务类型")
    private Integer taskType;

    /**机器编号*/
    @ApiModelProperty(value = "机器编号")
    private Long mId;

    /**机器名字*/
    @ApiModelProperty(value = "机器名字")
    private String machineName;

    /**网格公司Id*/
    @ApiModelProperty(value = "网格公司Id")
    private Long cId;

    /**网格公司名字*/
    @ApiModelProperty(value = "网格公司名字")
    private String companyName;

    /**子公司Id*/
    @ApiModelProperty(value = "子公司Id")
    private Long bId;

    /**子公司名字*/
    @ApiModelProperty(value = "子公司名字")
    private String bCompanyName;

    /**详情*/
    /**任务内容*/
    @ApiModelProperty(value = "任务内容")
    private String taskDetails;

    /**执行人员*/
    @ApiModelProperty(value = "执行人员")
    private String userName;

    /**省*/
    @ApiModelProperty(value = "省")
    private String province;

    /**市*/
    @ApiModelProperty(value = "市")
    private String city;

    /**区*/
    @ApiModelProperty(value = "区")
    private String area;

    /**具体位置*/
    @ApiModelProperty(value = "具体位置")
    private String addr;

    /**到场时间*/
    @ApiModelProperty(value = "到场时间")
    private Date startTime;

    /**任务用时*/
    @ApiModelProperty(value = "任务用时")
    private Long times;
    private String timess;

    private String taskStartPic;
    private String taskEndPic;

    private Long assigner;

    public Long getAssigner() {
        return assigner;
    }

    public void setAssigner(Long assigner) {
        this.assigner = assigner;
    }

    public String getTaskStartPic() {
        return taskStartPic;
    }

    public void setTaskStartPic(String taskStartPic) {
        this.taskStartPic = taskStartPic;
    }

    public String getTaskEndPic() {
        return taskEndPic;
    }

    public void setTaskEndPic(String taskEndPic) {
        this.taskEndPic = taskEndPic;
    }

    public String getTimess() {
        return timess;
    }

    public void setTimess(String timess) {
        this.timess = timess;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

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

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getbCompanyName() {
        return bCompanyName;
    }

    public void setbCompanyName(String bCompanyName) {
        this.bCompanyName = bCompanyName;
    }

}
