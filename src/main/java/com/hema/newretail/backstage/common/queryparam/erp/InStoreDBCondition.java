package com.hema.newretail.backstage.common.queryparam.erp;

import java.util.Date;
import java.util.List;

/**
 * @Department 新零售
 * @ClassName InStoreInStoreCondition
 * @Description 分后台---db
 * 提交入库
 * @Author ---CWZ
 * @Date 2018/11/3 11:47
 * @Version 1.0
 **/
public class InStoreDBCondition {
    private Long id;

    private Long companyId;

    private Long userId;

    private Date time;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
