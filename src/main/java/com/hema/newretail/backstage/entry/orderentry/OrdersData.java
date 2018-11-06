package com.hema.newretail.backstage.entry.orderentry;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 程文政
 * @Date: 2018/8/23 09:21
 * @Description:出货订单实体类 ---------------对应mongoDB
 * @Version: 1.0
 */
public class OrdersData {

    private String id;

    private String billId;

    private BigDecimal amt;

    private BigDecimal discount;

    private Integer num;

    private String bigPic;

    private String smallPic;

    private String menuName;

    private String recommend;

    private Long machineId;//(机器编码): int （扫码制作，用户确认后提交）

    private String deviceNumber;//设备序列号（扫码制作，用户确认后提交）

    private String province;

    private String city;

    private String area;

    private String agent;//代理

    private String grid;//网络

    private Date productionTime;//制作时间

    private BigDecimal price;

    private Date orderTime;



    private String orderStatus;//001未制作，002已制作，003未领取，004已领取 默认000账单未付款

    private Integer menuId;

    private List<OrderIngredients> orderIngredients;

    private List<Properties> properties;

    private String remarks;//备注

    private String waterTemperature;//水温 0 常温，1 热水，2 冷水

    private String deviceLocation;//设备位置


    public String getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(String waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

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

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }



    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public List<OrderIngredients> getOrderIngredients() {
        return orderIngredients;
    }

    public void setOrderIngredients(List<OrderIngredients> orderIngredients) {
        this.orderIngredients = orderIngredients;
    }

    public List<Properties> getProperties() {
        return properties;
    }

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }
}
