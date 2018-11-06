package com.hema.newretail.backstage.common.queryparam.authority;

/**
 * @Auther: 程文政
 * @Date: 2018/9/12 15:16
 * @Description:
 * @Version: 1.0
 */
public class TagCondition {
    private String menuName;
    private Long tagId;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
