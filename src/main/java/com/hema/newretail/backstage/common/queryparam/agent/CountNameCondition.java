package com.hema.newretail.backstage.common.queryparam.agent;

/**
 * @Department 新零售
 * @ClassName TagCountTagNameCondition
 * @Description 用来验证修改时是否出现重复名字
 * @Author ---CWZ
 * @Date 2018/10/24 10:07
 * @Version 1.0
 **/
public class CountNameCondition {


    private Long id ;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
