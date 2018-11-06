package com.hema.newretail.backstage.model.tag;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class BaseTagEditBo {

    private Long tagId;
    @NotNull(message = "标签名不能为空")
    @Size(min=2, max=30,message = "2到18个字符")
    private String tagName;

    private List<BaseTagRuleEditBo> tagRules;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<BaseTagRuleEditBo> getTagRules() {
        return tagRules;
    }

    public void setTagRules(List<BaseTagRuleEditBo> tagRules) {
        this.tagRules = tagRules;
    }
}