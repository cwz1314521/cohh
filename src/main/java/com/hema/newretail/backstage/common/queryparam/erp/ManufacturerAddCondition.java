package com.hema.newretail.backstage.common.queryparam.erp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName ManufacturerAddCondition
 * @Description 原料厂商---添加
 * @Author ---CWZ
 * @Date 2018/10/31 9:45
 * @Version 1.0
 **/
@ApiModel(value = "原料厂商---添加",description = "原料厂商---添加")
public class ManufacturerAddCondition {


    @ApiModelProperty(value = "登录账号（用户名）")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "合同图片url")
    private List<String> contractPics;
    @ApiModelProperty(value = "原料厂商名称")
    private String companyName;
    @ApiModelProperty(value = "备注")
    private String remark;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getContractPics() {
        return contractPics;
    }

    public void setContractPics(List<String> contractPics) {
        this.contractPics = contractPics;
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
}
