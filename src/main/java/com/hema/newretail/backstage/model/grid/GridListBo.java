package com.hema.newretail.backstage.model.grid;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Department 新零售
 * @ClassName GridListBo
 * @Description 新零售网格部分列表返回值类----GridController
 * @Author ---CWZ
 * @Date 2018/9/26 10:56
 * @Version 1.0
 **/
public class GridListBo {

    private String companyName;

    private Long id;

    private BigDecimal amount;

    private BigDecimal integral;

    private Date gmtCreate;

    private Integer status;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
