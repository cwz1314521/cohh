package com.hema.newretail.backstage.model.diy;

import java.math.BigDecimal;

/**
 * @Department 新零售
 * @ClassName IngredientEventBo
 * @Description diy配料设置列表
 * @Author ---CWZ
 * @Date 2018/10/18 11:12
 * @Version 1.0
 **/
public class IngredientEventBo {

    private Long id ;

    private String ingredientName;

    private BigDecimal maxIngredient;

    private Integer maxTime;

    private Integer eventAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public BigDecimal getMaxIngredient() {
        return maxIngredient;
    }

    public void setMaxIngredient(BigDecimal maxIngredient) {
        this.maxIngredient = maxIngredient;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public Integer getEventAccount() {
        return eventAccount;
    }

    public void setEventAccount(Integer eventAccount) {
        this.eventAccount = eventAccount;
    }
}
