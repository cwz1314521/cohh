package com.hema.newretail.backstage.entry.agent;


import java.math.BigDecimal;
import java.util.Date;

public class AgentAccountEntry {
    private Long id;

    private Long agentUserId;

    private BigDecimal amount;

    private Date gmtModified;

    private Date gmtCreate;

    private BigDecimal materialAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentUserId() {
        return agentUserId;
    }

    public void setAgentUserId(Long agentUserId) {
        this.agentUserId = agentUserId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public BigDecimal getMaterialAccount() {
        return materialAccount;
    }

    public void setMaterialAccount(BigDecimal materialAccount) {
        this.materialAccount = materialAccount;
    }
}