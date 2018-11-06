package com.hema.newretail.backstage.common.queryparam.ingredientstypemodelorcondition;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Auther: 程文政
 * @Date: 2018/8/31 14:33
 * @Description:
 * @Version: 1.0
 */

public class BoxGroupIngredientCondition {
    //主键

    private Long id;

    //名字
    @Size(min = 1,max = 20,message = "1~20个字符")
    private String name;

    //描述
    @Size(min = 1,max = 200,message = "1~200个字符")
    private String desc;


    //0 正常 1 删除
    private Boolean isDeleted;

    //机器类型
    private Long machineTypeId;

    private List<BaseIngredientBoxCondition> list;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }




    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Long machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public List<BaseIngredientBoxCondition> getList() {
        return list;
    }

    public void setList(List<BaseIngredientBoxCondition> list) {
        this.list = list;
    }
}
