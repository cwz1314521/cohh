package com.hema.newretail.backstage.model.menu;

/**
 * hema-newetaril-com.hema.newretail.backstage.model.menu
 *
 * @Description:
 * @Author: ZhangHaiSheng
 * @Date: 2018-08-25 9:57
 */
public class TagMenuBo {
    private Long menuId;
    private Integer num;
    private Boolean ruleType;
    private Long tagId;
    private String tagname;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Boolean getRuleType() {
        return ruleType;
    }

    public void setRuleType(Boolean ruleType) {
        this.ruleType = ruleType;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }
}
