package com.hema.newretail.backstage.entry.orderentry;

/**
 * @Auther: 程文政
 * @Date: 2018/8/28 16:45
 * @Description:
 * @Version: 1.0
 */
public class OrderExcleEntry {

    /**订单Id*/
    private String billId ;

    /**订单时间*/
    private String billTime ;

    /**购买用户*/
    private String nickName ;

    /**购买明细*/
    private String details ;

    /**订单金额*/
    private String amt ;

    /**订单状态*/
    private String billStatus ;

    /**支付方式*/
    private String paymentType ;

    /**支付流水号*/
    private String paySerialNumbers ;

    /**出货情况*/
    private String clearStatus ;

    /**备注*/
    private String remark ;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
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

    public String getClearStatus() {
        return clearStatus;
    }

    public void setClearStatus(String clearStatus) {
        this.clearStatus = clearStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
