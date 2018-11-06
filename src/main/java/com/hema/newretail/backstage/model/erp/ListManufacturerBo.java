package com.hema.newretail.backstage.model.erp;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName ListManufacturerBo
 * @Description 列表-查询原料厂商
 * @Author ---CWZ
 * @Date 2018/10/31 14:38
 * @Version 1.0
 **/
public class ListManufacturerBo {

    private Long id;

    private String companyName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
