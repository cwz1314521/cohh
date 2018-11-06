package com.hema.newretail.backstage.entry;

import java.math.BigDecimal;
import java.util.Date;

public class RefAgentGridAccount {
    private Long agentId;

    private Long gridCompanyId;

    private String gridCompanyName;

    private BigDecimal account;

    private Date gmtCreate;

    private Date effectiveTime;

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getGridCompanyId() {
        return gridCompanyId;
    }

    public void setGridCompanyId(Long gridCompanyId) {
        this.gridCompanyId = gridCompanyId;
    }

    public String getGridCompanyName() {
        return gridCompanyName;
    }

    public void setGridCompanyName(String gridCompanyName) {
        this.gridCompanyName = gridCompanyName == null ? null : gridCompanyName.trim();
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}