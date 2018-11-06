package com.hema.newretail.backstage.model.erp;

import java.util.Date;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName OrderListAddressBo
 * @Description 订单列表---地址
 * @Author ---CWZ
 * @Date 2018/11/1 15:36
 * @Version 1.0
 **/
public class OrderListAddressBo {

    private Long id;

    /**公司名称*/
    private String companyName;

    /**联系人*/
    private String contact;

    /**手机号*/
    private String tel;

    /**送达时间*/
    private Date deliveryTime;

    /**详细地址*/
    private String addr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private List<AddressIngredientBo> ingredientNum;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<AddressIngredientBo> getIngredientNum() {
        return ingredientNum;
    }

    public void setIngredientNum(List<AddressIngredientBo> ingredientNum) {
        this.ingredientNum = ingredientNum;
    }
}
