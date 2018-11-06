package com.hema.newretail.backstage.entry.orderentry;


import com.hema.newretail.backstage.common.utils.TimeUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by jiahao on 2018-08-06
 */
public class BillData implements Serializable {

    private String id;
    private String openId;
    /**
     *
     */
    private String nickName;//用户昵称
    private String phoneNumber;//用户手机号
    private BigDecimal amt;
    private BigDecimal discount;
    private Integer totalNum;
    private Date billTime;
    private String billStatus;//账单状态：默认（001）未付款、002已付款、003退款中，004退款成功
    private String paySerialNumbers;//支付流水号（支付回调修改）
    private String paymentType;//支付方式（支付回调修改），001微信、002支付宝、默认000
    private List orders;

    private String paymentStatus;//支付状态 默认：000， 成功：001

    private String remark;

    private String billTimeStr;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getPaySerialNumbers() {
        return paySerialNumbers;
    }

    public void setPaySerialNumbers(String paySerialNumbers) {
        this.paySerialNumbers = paySerialNumbers;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getBillTimeStr() {
        return TimeUtil.getStringByDate(this.billTime);
    }

    public void setBillTimeStr(String billTimeStr) {
        this.billTimeStr = billTimeStr;
    }
}

