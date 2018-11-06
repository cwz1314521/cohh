package com.hema.newretail.backstage.common.queryparam;

/**
 * @Description: 分公司地图展示查询分公司名称接口的参数类
 * @Author: Mr.Yang
 * @Date: 2018/10/13
 **/
public class BaseCompanyNameQueryParameter {
    private String province;
    private String city;
    private String area;
    private String nameOrCode;
    private int pageSize;
    private int pageNum;

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

    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
