package com.hema.newretail.backstage.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "BaseCompanyData")
public class BaseCompanyData {
    private Long id;

    @NotEmpty(message = "公司名称不可为空")
    @NotNull
    @Size(min = 1,max = 20)
    @ApiModelProperty("公司名称")
    private String companyName;

    @NotEmpty(message = "手机号不可为空")
    @NotNull
    @Size(min = 1,max = 11)
    @ApiModelProperty("手机号")
    private String contactWay;

    @NotEmpty(message = "联系人姓名不可为空")
    @NotNull
    @Size(min = 1,max = 10)
    @ApiModelProperty("联系人姓名")
    private String contact;

    private String province;

    private String city;

    private String area;

    @NotEmpty(message = "详细地址不可为空")
    @NotNull
    @Size(min = 1,max = 30)
    @ApiModelProperty("详细地址")
    private String addr;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer status;

    @Size(min = 1,max = 300)
    @ApiModelProperty("备注")
    private String remark;

    private List<String> geoHashCodes;

    @ApiModelProperty("省+市+区")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public List<String> getGeoHashCodes() {
        return geoHashCodes;
    }

    public void setGeoHashCodes(List<String> geoHashCodes) {
        this.geoHashCodes = geoHashCodes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}