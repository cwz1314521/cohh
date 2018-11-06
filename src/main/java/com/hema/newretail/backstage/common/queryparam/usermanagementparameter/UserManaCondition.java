package com.hema.newretail.backstage.common.queryparam.usermanagementparameter;

/**
 * @Auther: 程文政
 * @Date: 2018/8/22 13:51
 * @Description:  用户条件查询    参数类
 * @Version: 1.0
 */
public class UserManaCondition {


    private Integer pageNum;//页码

    private Integer pageSize;//每页记录数

    /**
     * 条件查询
     * */
    private String tag;//   标签查询

    private String nickname;//   昵称

    private Double preWeekRental;//本周金额查询  起始

    private Double weekRental;//本周金额查询  终止

    private String preRegistrationDate;//起始日期

    private String registrationDate;//终止日期

    private String status; //状态  0正常/1冻结

    private String province;

    private String city;

    private String area;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getPreWeekRental() {
        return preWeekRental;
    }

    public void setPreWeekRental(Double preWeekRental) {
        this.preWeekRental = preWeekRental;
    }

    public Double getWeekRental() {
        return weekRental;
    }

    public void setWeekRental(Double weekRental) {
        this.weekRental = weekRental;
    }

    public String getPreRegistrationDate() {
        return preRegistrationDate;
    }

    public void setPreRegistrationDate(String preRegistrationDate) {
        this.preRegistrationDate = preRegistrationDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
