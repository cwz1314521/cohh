package com.hema.newretail.backstage.model.grid;

/**
 * @Department 新零售
 * @ClassName BoxLogBo
 * @Description 任务列表详情内部返回值类
 * @Author ---CWZ
 * @Date 2018/10/15 11:51
 * @Version 1.0
 **/
public class BoxLogBo {
    private int boxCode;
    private String ingredientName;

    public int getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(int boxCode) {
        this.boxCode = boxCode;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
