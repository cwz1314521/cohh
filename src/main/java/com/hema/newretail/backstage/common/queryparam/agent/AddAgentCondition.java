package com.hema.newretail.backstage.common.queryparam.agent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @Department 新零售
 * @ClassName AddAgentCondition
 * @Description 代理公司 添加参数类
 * @Author ---CWZ
 * @Date 2018/10/8 11:40
 * @Version 1.0
 **/
@ApiModel(description = "AddAgentCondition")
public class AddAgentCondition {

    /**账号*/
    @ApiModelProperty(value = "账号")
    @NotBlank(message = "账号不可为空")
    @Length(max=11,message="账号长度不能大于11位")
    @Pattern(regexp = "^(1[1-9][0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$", message = "手机号格式错误")
    private String tel;


    /**状态*/
    @ApiModelProperty(value = "状态")
    @NotNull(message = "状态不可为空")
    private Integer status;

    /**公司名称*/
    @ApiModelProperty(value = "公司名称")
    @NotBlank(message = "公司名称不可为空")
    @Pattern(regexp = "[^\\w\\s]+",message = "公司名称只能是汉字和符号")
    @Length(min = 1,max = 20,message = "公司名称在1到20个字符中间")
    private String companyName;

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
    @NotBlank(message = "省不可为空")
    private String province;
    /**市*/
    @ApiModelProperty(value = "市")
    @NotBlank(message = "市不可为空")
    private String city;
    /**区*/
    @ApiModelProperty(value = "区")
    @NotBlank(message = "区不可为空")
    private String area;
    /**详细地址*/
    @ApiModelProperty(value = "详细地址")
    @NotBlank(message = "详细地址不可为空")
    @Length(min = 1,max = 30,message = "详细地址在1到30个字符中间")
    private String addr;
    /**开户行*/
    @ApiModelProperty(value = "开户行")
    @NotBlank(message = "开户行不可为空")
    @Length(min = 1,max = 30,message = "开户行在1到30个字符中间")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]+$",message = "开户行只能为汉字")
    private String bank;
    /**收款账号*/
    @ApiModelProperty(value = "收款账号")
    @NotBlank(message = "收款账号不可为空")
    @Length(min = 1,max = 25,message = "收款账号在1到25位")
    @Pattern(regexp = "^[1-9]\\d*$",message = "收款账号只能为数字")
    private String accountNumber;

    /**收款人*/
    @ApiModelProperty(value = "收款人")
    @NotBlank(message = "收款人不可为空")
    @Pattern(regexp = "[^\\w\\s]+",message = "收款人只能是汉字和符号")
    @Length(min = 1,max = 20,message = "收款人在1到20个字符中间")
    private String accountName;
    /**备注*/
    @ApiModelProperty(value = "备注")
    @Length(max = 150,message = "备注在150字以内")
    private String remark;


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
