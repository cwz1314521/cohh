package com.hema.newretail.backstage.model.erp;

import java.util.List;

/**
 * @Department 新零售
 * @ClassName InStoreTodayBo
 * @Description 分后台  当天未入库列表-一级参数类
 * @Author ---CWZ
 * @Date 2018/11/3 10:56
 * @Version 1.0
 **/
public class InStoreTodayBo {

    private Long id;
    private String orderCode;
    private List<InStoreTodaySonBo>  ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<InStoreTodaySonBo> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<InStoreTodaySonBo> ingredients) {
        this.ingredients = ingredients;
    }
}
