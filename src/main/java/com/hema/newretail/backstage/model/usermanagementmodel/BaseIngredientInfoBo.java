package com.hema.newretail.backstage.model.usermanagementmodel;

import java.math.BigDecimal;
import java.util.Date;

public class BaseIngredientInfoBo {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String ingredientName;

    private String ingredientCode;

    private String ingredientDescription;

    private String ingredientPic;

    private BigDecimal ingredientPrice;

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

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName == null ? null : ingredientName.trim();
    }

    public String getIngredientCode() {
        return ingredientCode;
    }

    public void setIngredientCode(String ingredientCode) {
        this.ingredientCode = ingredientCode == null ? null : ingredientCode.trim();
    }

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription == null ? null : ingredientDescription.trim();
    }

    public String getIngredientPic() {
        return ingredientPic;
    }

    public void setIngredientPic(String ingredientPic) {
        this.ingredientPic = ingredientPic == null ? null : ingredientPic.trim();
    }

    public BigDecimal getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(BigDecimal ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }
}