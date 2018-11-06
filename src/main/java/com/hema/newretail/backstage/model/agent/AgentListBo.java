package com.hema.newretail.backstage.model.agent;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName AgentListBo
 * @Description AgentList  ---   代理公司列表 ---  返回值类
 * @Author ---CWZ
 * @Date 2018/9/25 10:47
 * @Version 1.0
 **/
public class AgentListBo {
    /**主键*/
    private Long id;
    /**状态*/
    private Integer status;
    /**添加时间*/
    private Date gmtCreate;
    /**公司名字*/
    private String companyName;
    /**银行*/
    private String bank;
    /**账户*/
    private BigDecimal amount;
    /**代理账户*/
    private BigDecimal materialAccount;
    /**登录账号*/
    private String tel;
    /**联系方式*/
    private String contactWay;
    /**联系人*/
    private String contact;
    /**省*/
    private String province;
    /**市*/
    private String city;
    /**区*/
    private String area;
    /**具体地址*/
    private String addr;
    /**收款账户*/
    private String accountNumber;
    /**账户名*/
    private String accountName;
    /**备注*/
    private String remark;


    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMaterialAccount() {
        return materialAccount;
    }

    public void setMaterialAccount(BigDecimal materialAccount) {
        this.materialAccount = materialAccount;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
