package com.hema.newretail.backstage.common.queryparam.grid;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.common.queryparam.grid
 *
 * @author ZhangHaiSheng
 * @link
 * @date 2018-10-17 10:25
 */
public class LookMapGridCompanyListCondition {
    private String province;
    private String city;
    private String area;

    /**
     * 页码  默认为1
     */
    @NotNull(message = "页码不可以为空")
    private Integer pageNum;

    /**
     * 每页最大数  默认为10
     */
    @NotNull(message = "每页最大数不可以为空")
    private Integer pageSize;

    private String nameOrCode;

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

    @NotNull
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(@NotNull Integer pageNum) {
        this.pageNum = pageNum;
    }

    @NotNull
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(@NotNull Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getNameOrCode() {
        return nameOrCode;
    }

    public void setNameOrCode(String nameOrCode) {
        this.nameOrCode = nameOrCode;
    }
}
