package com.hema.newretail.backstage.common.queryparam;

import java.util.List;

/**
 * @Description: 分公司查询条件实体类
 * @Author: Mr.Yang
 * @Date: 2018/09/26
 **/
public class BaseCompanyQueryParameter {

    private String companyNameOrId;

    private String companyName;

    private Long id;

    private String province;

    private String city;

    private List<String> area;

    private Integer status;

    private int pageSize;

    private int pageNum;

    public String getCompanyNameOrId() {
        return companyNameOrId;
    }

    public void setCompanyNameOrId(String companyNameOrId) {
        this.companyNameOrId = companyNameOrId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getArea() {
        return area;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
