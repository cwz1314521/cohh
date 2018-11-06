package com.hema.newretail.backstage.common.queryparam.grid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@ApiModel(description = "GridEditCondition")
public class GridEditCondition {

    @NotNull(message = "id不可以为空")
    @ApiModelProperty(value = "id")
    private Long id;


    /**子公司归属*/
    @ApiModelProperty(value = "子公司归属")
    private Long companyId;

    /**账号*/
    @ApiModelProperty(value = "账号")
    @Length(min = 1,max = 20,message = "公司名称在1到20个字符中间")
    @NotBlank(message = "账号不可为空")
    @Pattern(regexp = "^[^\\u4e00-\\u9fa5]+$", message = "密码由数字字母符号构成")
    private String userName;

    /**联系方式*/
    @ApiModelProperty(value = "联系方式")
    @NotBlank(message = "联系方式不可为空")
    @Length(max=11,message="手机号长度不能大于11位")
    @Pattern(regexp = "^(1[1-9][0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$", message = "手机号格式错误")
    private String contactWay;

    /**联系人*/
    @ApiModelProperty(value = "联系人")
    @Length(min = 1,max = 10,message = "联系人在1到10个字中间")
    @NotBlank(message = "联系人不可为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$",message = "联系人只能是汉字")
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
    @ApiModelProperty(value = "详细地址")
    @NotBlank(message = "详细地址不可为空")
    @Length(min = 1,max = 30,message = "详细地址在1到30个字符中间")
    private String addr;

    /**状态*/
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**备注*/
    @ApiModelProperty(value = "备注")
    @NotBlank(message = "备注不可为空")
    @Length(max = 150,message = "备注在150字以内")
    private String remark;

    /**开户行*/
    @ApiModelProperty(value = "开户行")
    @NotBlank(message = "开户行不可为空")
    @Length(min = 1,max = 30,message = "开户行在1到30个字符中间")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$",message = "开户行只能为汉字")
    private String bank;

    /**账户*/
    @ApiModelProperty(value = "收款账号")
    @NotBlank(message = "收款账号不可为空")
    @Length(min = 1,max = 25,message = "收款账号在1到25位")
    @Pattern(regexp = "^[1-9]\\d*$",message = "收款账号只能为数字")
    private String accountNumber;

    /**账户名*/
    @ApiModelProperty(value = "账户名")
    @NotBlank(message = "账户名不可为空")
    @Pattern(regexp = "[^\\w\\s]+",message = "收款人只能是汉字和符号")
    @Length(min = 1,max = 20,message = "收款人在1到20个字符中间")
    private String accountName;


    /**每分对应金额*/
    @ApiModelProperty(value = "每分对应金额")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @NotNull(message = "每分对应金额不可为空")
    private BigDecimal rewardAmount;

    /**补货任务时间*/
    @ApiModelProperty(value = "补货任务时间")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @NotNull(message = "补货任务时间不可为空")
    private Integer replenishmentTime;

    /**保洁任务时间*/
    @ApiModelProperty(value = "保洁任务时间")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @NotNull(message = "保洁任务时间不可为空")
    private Integer cleanupReward;

    /**换件任务时间*/
    @ApiModelProperty(value = "换件任务时间")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @NotNull(message = "换件任务时间不可为空")
    private Integer replaceReward;

    /**维修任务时间*/
    @ApiModelProperty(value = "维修任务时间")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @NotNull(message = "维修任务时间不可为空")
    private Integer maintenanceReward;

    /**巡检任务时间*/
    @ApiModelProperty(value = "巡检任务时间")
    @DecimalMax(value = "99999",message = "输入范围有误 0-99999")
    @DecimalMin(value = "0",message = "输入范围有误 0-99999")
    @NotNull(message = "巡检任务时间不可为空")
    private Integer inspectionReward;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
}