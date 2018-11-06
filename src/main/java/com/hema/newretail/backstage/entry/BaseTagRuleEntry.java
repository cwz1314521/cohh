package com.hema.newretail.backstage.entry;

public class BaseTagRuleEntry {
    private Long id;

    private Long tagId;

    private Boolean ruleType;

    private Long menuId;

    private String menuName;

    private Integer num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Boolean getRuleType() {
        return ruleType;
    }

    public void setRuleType(Boolean ruleType) {
        this.ruleType = ruleType;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}