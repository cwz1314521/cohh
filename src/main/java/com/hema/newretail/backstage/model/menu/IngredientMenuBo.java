package com.hema.newretail.backstage.model.menu;

import java.math.BigDecimal;
import java.util.Date;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.menu
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-23 12:10
 */
public class IngredientMenuBo {

    private Long id;
    private String menuName;
    private BigDecimal price;
    private Long isRecommend;// 是否推荐
    private String smallPic;
    private String bigPic;
    private String middlePic;
    private Integer recommendOrder; //排序
    private Boolean status; //展示状态 0下架 1上架
    private Long saleNum;//销售数量
    private BigDecimal saleAmount; //销售额
    private Double yearOnYearSaleNum; // 同比
    private Double ringRatioSaleNum;// 环比
    private Double yearOnYearSaleAmount; // 同比
    private Double ringRatioSaleAmount;// 环比

    private String anyPic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        this.smallPic = smallPic;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getMiddlePic() {
        return middlePic;
    }

    public void setMiddlePic(String middlePic) {
        this.middlePic = middlePic;
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

    public Long getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Long saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Double getYearOnYearSaleNum() {
        return yearOnYearSaleNum;
    }

    public void setYearOnYearSaleNum(Double yearOnYearSaleNum) {
        this.yearOnYearSaleNum = yearOnYearSaleNum;
    }

    public Double getRingRatioSaleNum() {
        return ringRatioSaleNum;
    }

    public void setRingRatioSaleNum(Double ringRatioSaleNum) {
        this.ringRatioSaleNum = ringRatioSaleNum;
    }

    public Double getYearOnYearSaleAmount() {
        return yearOnYearSaleAmount;
    }

    public void setYearOnYearSaleAmount(Double yearOnYearSaleAmount) {
        this.yearOnYearSaleAmount = yearOnYearSaleAmount;
    }

    public Double getRingRatioSaleAmount() {
        return ringRatioSaleAmount;
    }

    public void setRingRatioSaleAmount(Double ringRatioSaleAmount) {
        this.ringRatioSaleAmount = ringRatioSaleAmount;
    }

    public String getAnyPic() {
        return anyPic;
    }

    public void setAnyPic(String anyPic) {
        this.anyPic = anyPic;
    }
}
