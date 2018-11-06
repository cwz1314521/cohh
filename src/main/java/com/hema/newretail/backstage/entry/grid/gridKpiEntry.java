package com.hema.newretail.backstage.entry.grid;

import java.util.Date;

public class gridKpiEntry {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long kpi;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getKpi() {
        return kpi;
    }

    public void setKpi(Long kpi) {
        this.kpi = kpi;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}