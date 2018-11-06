package com.hema.newretail.backstage.model.billdetailmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: 程文政
 * @Date: 2018/8/23 09:21
 * @Description:出货订单返回值类 ---------------对应mongoDB
 * @Version: 1.0
 */
public class OrdersDataBo {

    private String id;

    private String billId;

    private String menuName;

    private String deviceNumber;//设备序列号（扫码制作，用户确认后提交）

    private String deviceLocation;//设备位置

    private String agent;//代理

    private String grid;//网络

    private Date productionTime;//制作时间

    private String orderStatus;//001未制作，002已制作，003未领取，004已领取 默认000账单未付款

    private String remark;//备注

    private String waterTemperature;//水温 0 常温，1 热水，2 冷水

    private String options;//选项 甜度

    private BigDecimal money;//钱


    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(String waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
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

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
