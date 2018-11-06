package com.hema.newretail.backstage.model.agent;

import java.math.BigDecimal;

/**
 * @Department 新零售
 * @ClassName AgentGridListBo
 * @Description 代理旗下的网格
 * @Author ---CWZ
 * @Date 2018/9/26 17:01
 * @Version 1.0
 **/
public class AgentGridListBo {
    /**账户名*/
    private String gridComPanyName;

    /**账户余额*/
    private BigDecimal account;

    public String getGridComPanyName() {
        return gridComPanyName;
    }

    public void setGridComPanyName(String gridComPanyName) {
        this.gridComPanyName = gridComPanyName;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }
}
