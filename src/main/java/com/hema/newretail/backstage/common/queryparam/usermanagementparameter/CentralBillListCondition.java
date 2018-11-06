package com.hema.newretail.backstage.common.queryparam.usermanagementparameter;

/**
 * @Auther: 程文政
 * @Date: 2018/8/24 13:34
 * @Description:   订单中心查询参数类
 * @Version: 1.0
 */
public class CentralBillListCondition {

    private String id;//主键 账单号

    private String paySerialNumbers;//支付流水号

    private String preAmt;//订单金额

    private String amt;//订单金额

    private String preBillTime;//订单时间

    private String billTime;//订单时间

    private String nickName;//用户名

    private String phoneNumber;//电话号

    private String paymentType;//支付方式

    private String billStatus;//状态



    private Integer pageSize;

    private Integer pageNum;


    //省查询
    private String province;

    //市查询
    private String city;

    //区查询
    private String area;

    //代理查询
    private String agent;

    //网格查询
    private String grid;

    //出货状态
    private String orderStatus;

    //机器编号查询
    private String deviceNumber;

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
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

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaySerialNumbers() {
        return paySerialNumbers;
    }

    public void setPaySerialNumbers(String paySerialNumbers) {
        this.paySerialNumbers = paySerialNumbers;
    }

    public String getPreAmt() {
        return preAmt;
    }

    public void setPreAmt(String preAmt) {
        this.preAmt = preAmt;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getPreBillTime() {
        return preBillTime;
    }

    public void setPreBillTime(String preBillTime) {
        this.preBillTime = preBillTime;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}
