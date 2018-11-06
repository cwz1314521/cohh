package com.hema.newretail.backstage.model.erp;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName ManufacturerListBo
 * @Description 原料厂商---总后台列表展示Bo
 * @Author ---CWZ
 * @Date 2018/10/31 14:38
 * @Version 1.0
 **/
public class ManufacturerListBo {

    private Long id;

    private String userName;

    private String password;

    private String companyCode;

    private String companyName;

    private String remark;

    private List<String> contractPics;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getContractPics() {
        return contractPics;
    }

    public void setContractPics(List<String> contractPics) {
        this.contractPics = contractPics;
    }
}
