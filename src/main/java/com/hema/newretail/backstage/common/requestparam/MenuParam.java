package com.hema.newretail.backstage.common.requestparam;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author jiahao
 */
public class MenuParam {

    private Long id;

    private String menuName;

    private BigDecimal price;

    private String smallPic;

    private String middlePic;

    private String bigPic;

    private String anyPic;

    /**
     * 配料的添加
     */
    private List<MaterialParam> materialParamList;

    /**
     * 属性的选项的添加
     */
    private List<OptionParam> optionParamList;

    /**
     * 编辑时标签的修改
     */
    private List<TagParam> tagParamList;

    private Boolean status;

    private Integer recommendOrder;

    private Long isRecommend;

    public String getAnyPic() {
        return anyPic;
    }

    public void setAnyPic(String anyPic) {
        this.anyPic = anyPic;
    }

    public Long getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Long isRecommend) {
        this.isRecommend = isRecommend;
    }

    public List<TagParam> getTagParamList() {
        return tagParamList;
    }

    public void setTagParamList(List<TagParam> tagParamList) {
        this.tagParamList = tagParamList;
    }

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

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public String getMiddlePic() {
        return middlePic;
    }

    public void setMiddlePic(String middlePic) {
        this.middlePic = middlePic;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public List<MaterialParam> getMaterialParamList() {
        return materialParamList;
    }

    public void setMaterialParamList(List<MaterialParam> materialParamList) {
        this.materialParamList = materialParamList;
    }

    public List<OptionParam> getOptionParamList() {
        return optionParamList;
    }

    public void setOptionParamList(List<OptionParam> optionParamList) {
        this.optionParamList = optionParamList;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRecommendOrder() {
        return recommendOrder;
    }

    public void setRecommendOrder(Integer recommendOrder) {
        this.recommendOrder = recommendOrder;
    }
}
