package com.hema.newretail.backstage.model.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "GridEditBo")
public class GridEditBo {



    /**子公司归属*/
    @ApiModelProperty(value = "子公司归属")
    private Long companyId;
    /**子公司归属*/
    @ApiModelProperty(value = "子公司归属")
    private Long id;

    /**子公司归属*/
    @ApiModelProperty(value = "子公司名字")
    private String bCompanyName;


    /**公司名称*/
    @ApiModelProperty(value = "公司名称")
    private String companyName;



    /**账号*/
    @ApiModelProperty(value = "账号")
    private String userName;

    /**联系方式*/
    @ApiModelProperty(value = "联系方式")
    private String contactWay;

    /**联系人*/
    @ApiModelProperty(value = "联系人")
    private String contact;

    /**省*/
    @ApiModelProperty(value = "省")
    private String province;

    /**城市*/
    @ApiModelProperty(value = "城市")
    private String city;

    /**区*/
    @ApiModelProperty(value = "区")
    private String area;

    /**具体地址*/
    @ApiModelProperty(value = "具体地址")
    private String addr;

    /**状态*/
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**备注*/
    @ApiModelProperty(value = "备注")
    private String remark;

    /**开户行*/
    @ApiModelProperty(value = "开户行")
    private String bank;

    /**账户*/
    @ApiModelProperty(value = "账户")
    private String accountNumber;

    /**账户名*/
    @ApiModelProperty(value = "账户名")
    private String accountName;


    /**每分对应金额*/
    @ApiModelProperty(value = "每分对应金额")
    private BigDecimal rewardAmount;

    /**补货任务时间*/
    @ApiModelProperty(value = "补货任务时间")
    private Integer replenishmentTime;

    /**保洁任务时间*/
    @ApiModelProperty(value = "保洁任务时间")
    private Integer cleanupReward;

    /**换件任务时间*/
    @ApiModelProperty(value = "换件任务时间")
    private Integer replaceReward;

    /**维修任务时间*/
    @ApiModelProperty(value = "维修任务时间")
    private Integer maintenanceReward;

    /**巡检任务时间*/
    @ApiModelProperty(value = "巡检任务时间")
    private Integer inspectionReward;


    public String getbCompanyName() {
        return bCompanyName;
    }

    public void setbCompanyName(String bCompanyName) {
        this.bCompanyName = bCompanyName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}