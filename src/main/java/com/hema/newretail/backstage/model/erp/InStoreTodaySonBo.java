package com.hema.newretail.backstage.model.erp;

/**
 * @Department 新零售
 * @ClassName InStoreTodayBo
 * @Description 分后台  当天未入库列表-二级参数类
 * @Author ---CWZ
 * @Date 2018/11/3 10:56
 * @Version 1.0
 **/
public class InStoreTodaySonBo {

    private String ingredientName;
    private Integer num;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
