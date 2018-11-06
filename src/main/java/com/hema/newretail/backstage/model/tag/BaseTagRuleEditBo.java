package com.hema.newretail.backstage.model.tag;

import javax.validation.constraints.Pattern;

public class BaseTagRuleEditBo {
    private Boolean ruleType;

    private Long menuId;

    private String menuName;
    @Pattern(regexp = "/^[1-9]+\\d*$/",message = "请填入正整数")
    private Integer num;

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
        this.menuName = menuName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}