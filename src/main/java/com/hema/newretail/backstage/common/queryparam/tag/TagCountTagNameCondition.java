package com.hema.newretail.backstage.common.queryparam.tag;

/**
 * @Department 新零售
 * @ClassName TagCountTagNameCondition
 * @Description 用来验证修改tag时是否出现重复名字
 * @Author ---CWZ
 * @Date 2018/10/24 10:07
 * @Version 1.0
 **/
public class TagCountTagNameCondition {


    private Long id ;
    private String tagname;

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
}
