package com.hema.newretail.backstage.common.queryparam.usermanagementparameter;

/**
 * @Auther: 程文政
 * @Date: 2018/8/23 14:10
 * @Description: 制作订单参数类
 * @Version: 1.0
 */
public class MakeOrderCondition {

    //页码
    private Integer pageNum;

    //记录数
    private Integer pageSize;

    //id查询 订单号
    private String id;

    //机器编号查询
    private String deviceNumber;

    //状态查询
    private String orderStatus;

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

    //前制作时间
    private String preOrderTime;

    //后制作时间
    private String orderTime;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getPreOrderTime() {
        return preOrderTime;
    }

    public void setPreOrderTime(String preOrderTime) {
        this.preOrderTime = preOrderTime;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
