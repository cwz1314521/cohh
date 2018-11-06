package com.hema.newretail.backstage.entry;

import java.math.BigDecimal;
import java.util.Date;

public class IngredientMenuEntry {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String menuName;

    private Long isDiy;

    private Long isDeleted;

    private BigDecimal price;

    private String diyKeywords;

    private Long isRecommend;

    private String smallPic;

    private String bigPic;

    private String middlePic;

    private Integer recommendOrder;

    private Boolean status;

    private String anyPic;

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Long getIsDiy() {
        return isDiy;
    }

    public void setIsDiy(Long isDiy) {
        this.isDiy = isDiy;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDiyKeywords() {
        return diyKeywords;
    }

    public void setDiyKeywords(String diyKeywords) {
        this.diyKeywords = diyKeywords == null ? null : diyKeywords.trim();
    }

    public Long getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Long isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic == null ? null : smallPic.trim();
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic == null ? null : bigPic.trim();
    }

    public String getMiddlePic() {
        return middlePic;
    }

    public void setMiddlePic(String middlePic) {
        this.middlePic = middlePic == null ? null : middlePic.trim();
    }

    public Integer getRecommendOrder() {
        return recommendOrder;
    }

    public void setRecommendOrder(Integer recommendOrder) {
        this.recommendOrder = recommendOrder;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAnyPic() {
        return anyPic;
    }

    public void setAnyPic(String anyPic) {
        this.anyPic = anyPic;
    }
}