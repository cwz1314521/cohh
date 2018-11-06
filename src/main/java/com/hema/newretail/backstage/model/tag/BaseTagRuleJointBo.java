package com.hema.newretail.backstage.model.tag;

/**
 * @Auther: 程文政
 * @Date: 2018/8/20 15:30
 * @Description:字段拼接model
 * @Version: 1.0
 */
public class BaseTagRuleJointBo {

    private Long id;

    private String tagname;

    private String tagJoint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getTagJoint() {
        return tagJoint;
    }

    public void setTagJoint(String tagJoint) {
        this.tagJoint = tagJoint;
    }

    @Override
    public String toString() {
        return "BaseTagRuleJointBo{" +
                "id=" + id +
                ", tagname='" + tagname + '\'' +
                ", tagJoint='" + tagJoint + '\'' +
                '}';
    }
}
