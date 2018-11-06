package com.hema.newretail.backstage.model.billdetailmodel;

import java.math.BigDecimal;
import java.util.List;
/**
 * @Auther: 程文政
 * @Date: 2018/8/23 17:38
 * @Description:
 * @Version: 1.0
 */
public class BillDataBo {

    private String id;//订单编号
    private BigDecimal totalMoney;//订单总价
    private Integer totalNum;//总杯数
    private String billTime;//订单时间
    private String paymentType;//支付方式（支付回调修改），001微信、002支付宝、默认000
    private String paySerialNumbers;//支付流水号（支付回调修改）
    private String paymentStatus;//支付状态 默认：000， 成功：001
    private String billStatus;//账单状态：默认（001）未付款、002已付款、003退款中，004退款成功
    private String userName;//购买用户
    private String tel;//手机号
    private List<OrdersDataBo> list;

    private String remark;

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

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaySerialNumbers() {
        return paySerialNumbers;
    }

    public void setPaySerialNumbers(String paySerialNumbers) {
        this.paySerialNumbers = paySerialNumbers;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<OrdersDataBo> getList() {
        return list;
    }

    public void setList(List<OrdersDataBo> list) {
        this.list = list;
    }
}

