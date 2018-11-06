package com.hema.newretail.backstage.entry.erp;

import java.util.Date;

public class ErpIngredientOrderAddressEntry {
    private Long id;

    private Long ingredientOrderId;

    private Long companyId;

    private Date deliveryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIngredientOrderId() {
        return ingredientOrderId;
    }

    public void setIngredientOrderId(Long ingredientOrderId) {
        this.ingredientOrderId = ingredientOrderId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "ErpIngredientOrderAddressEntry{" +
                "id=" + id +
                ", ingredientOrderId=" + ingredientOrderId +
                ", companyId=" + companyId +
                ", deliveryTime=" + deliveryTime +
                '}';
    }
}