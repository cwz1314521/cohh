package com.hema.newretail.backstage.model.erp;

import java.util.Date;

/**
 * @Department 新零售
 * @ClassName InStoreListBo
 * @Description 分后台  列表
 * @Author ---CWZ
 * @Date 2018/11/2 15:07
 * @Version 1.0
 **/
public class InStoreListBo {

    /**id*/
    private Long id;

    /**原料名称*/
    private String ingredientName;

    /**二维码编码*/
    private Date qualityGuaranteePeriod;

    /**有效期*/
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Date getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }

    public void setQualityGuaranteePeriod(Date qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
